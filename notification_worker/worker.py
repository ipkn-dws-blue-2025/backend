import json
import logging
import os
import time
from typing import Any, Dict, Optional, Tuple

import pika
import requests


VK_API_BASE_URL = "https://api.vk.com/method/"
DEDUP_TTL_SECONDS = 3600
_dedup_cache: Dict[Tuple[str, str], float] = {}


def setup_logger(log_file: str) -> logging.Logger:
    logger = logging.getLogger("notification_worker")
    logger.setLevel(logging.INFO)

    log_dir = os.path.dirname(log_file)
    if log_dir:
        os.makedirs(log_dir, exist_ok=True)

    formatter = logging.Formatter(
        "%(asctime)s | %(levelname)s | %(message)s"
    )

    file_handler = logging.FileHandler(log_file)
    file_handler.setLevel(logging.INFO)
    file_handler.setFormatter(formatter)

    console_handler = logging.StreamHandler()
    console_handler.setLevel(logging.INFO)
    console_handler.setFormatter(formatter)

    logger.addHandler(file_handler)
    logger.addHandler(console_handler)
    return logger


def connect_with_retry(params: pika.ConnectionParameters, logger: logging.Logger) -> pika.BlockingConnection:
    while True:
        try:
            logger.info("Connecting to RabbitMQ at %s:%s", params.host, params.port)
            return pika.BlockingConnection(params)
        except Exception as exc:
            logger.error("RabbitMQ connection failed: %s", exc)
            time.sleep(5)


def build_message_text(payload: Dict[str, Any]) -> Optional[str]:
    if payload.get("text"):
        return str(payload["text"])
    if payload.get("message"):
        return str(payload["message"])

    metric = payload.get("metric")
    instant_value = payload.get("instantValue")
    user_value = payload.get("userValue")
    timestamp = payload.get("timestamp")

    parts = []
    if metric:
        parts.append(f"Metric {metric}")
    if instant_value is not None:
        parts.append(f"value {instant_value}")
    if user_value is not None:
        parts.append(f"threshold {user_value}")
    if timestamp is not None:
        parts.append(f"at {timestamp}")

    if parts:
        return "Alert: " + ", ".join(parts)
    return None


def send_vk_notification(
    method: str,
    user_id: Optional[str],
    message: str,
    token: str,
    api_version: str,
    logger: logging.Logger,
    peer_id: Optional[str] = None,
    random_id: Optional[str] = None,
) -> Dict[str, Any]:
    url = f"{VK_API_BASE_URL}{method}"
    payload: Dict[str, Any] = {
        "message": message,
        "access_token": token,
        "v": api_version,
    }

    if method == "messages.send":
        if user_id and not peer_id:
            payload["user_id"] = user_id
        if peer_id:
            payload["peer_id"] = peer_id
        payload["random_id"] = random_id or str(int(time.time() * 1000))
    else:
        if user_id:
            payload["user_ids"] = user_id

    payload = {key: value for key, value in payload.items() if value is not None}
    response = requests.post(
        url,
        data=payload,
        timeout=10,
    )

    if response.status_code >= 500:
        raise requests.RequestException(
            f"VK API server error: {response.status_code}"
        )

    try:
        return response.json()
    except ValueError as exc:
        logger.error("VK API response is not JSON: %s", response.text)
        raise requests.RequestException("Invalid VK API response") from exc


def handle_message(
    ch: pika.channel.Channel,
    method: pika.spec.Basic.Deliver,
    body: bytes,
    token: str,
    api_version: str,
    vk_method: str,
    logger: logging.Logger,
) -> None:
    try:
        payload = json.loads(body.decode("utf-8"))
    except Exception:
        logger.exception("Failed to parse message: %s", body)
        ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    user_id = payload.get("userId") or payload.get("user_id")
    metric = payload.get("metric") or payload.get("metricType")
    peer_id = payload.get("peerId") or payload.get("peer_id")
    random_id = payload.get("randomId") or payload.get("random_id")
    message_text = build_message_text(payload)

    if not (user_id or peer_id) or not message_text:
        logger.error("Message missing user_id/peer_id or text: %s", payload)
        ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    cache_key_user = str(user_id) if user_id is not None else str(peer_id)
    cache_key_metric = str(metric) if metric else "unknown_metric"
    cache_key = (cache_key_user, cache_key_metric)
    now_ts = time.time()
    last_sent = _dedup_cache.get(cache_key)
    if last_sent and (now_ts - last_sent) < DEDUP_TTL_SECONDS:
        logger.info("Skip notification due to TTL dedup: key=%s", cache_key)
        ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    # Cleanup expired cache entries opportunistically.
    if len(_dedup_cache) > 0:
        expired_keys = [key for key, ts in _dedup_cache.items() if (now_ts - ts) >= DEDUP_TTL_SECONDS]
        for key in expired_keys:
            _dedup_cache.pop(key, None)

    try:
        response = send_vk_notification(
            method=vk_method,
            user_id=str(user_id) if user_id is not None else None,
            message=message_text,
            token=token,
            api_version=api_version,
            logger=logger,
            peer_id=str(peer_id) if peer_id else None,
            random_id=str(random_id) if random_id else None,
        )
    except requests.RequestException as exc:
        logger.error("VK request failed, will retry: %s", exc)
        ch.basic_nack(delivery_tag=method.delivery_tag, requeue=True)
        return

    if "error" in response:
        error = response.get("error", {})
        error_code = error.get("error_code")
        logger.warning("VK API error: %s", error)

        if error_code in {1, 6}:
            ch.basic_ack(delivery_tag=method.delivery_tag)
        else:
            ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    logger.info("Notification delivered via %s to user_id=%s", vk_method, user_id or peer_id)
    if not last_sent or (now_ts - last_sent) >= DEDUP_TTL_SECONDS:
        _dedup_cache[cache_key] = now_ts
    ch.basic_ack(delivery_tag=method.delivery_tag)


def main() -> None:
    rabbit_host = os.getenv("RABBIT_HOST", "localhost")
    rabbit_port = int(os.getenv("RABBIT_PORT", "5672"))
    rabbit_user = os.getenv("RABBIT_USERNAME", "guest")
    rabbit_password = os.getenv("RABBIT_PASSWORD", "guest")
    rabbit_queue = os.getenv("RABBIT_QUEUE", "notification_queue")

    vk_method = os.getenv("VK_API_METHOD", "messages.send")
    vk_token = os.getenv("VK_ACCESS_TOKEN") or os.getenv("VK_GROUP_TOKEN") or os.getenv("VK_SERVICE_TOKEN")
    vk_api_version = os.getenv("VK_API_VERSION", "5.199")

    log_file = os.getenv("LOG_FILE", "logs/notification_worker.log")
    logger = setup_logger(log_file)

    if not vk_token:
        logger.error("VK_ACCESS_TOKEN or VK_GROUP_TOKEN is not set, exiting.")
        raise SystemExit(1)

    credentials = pika.PlainCredentials(rabbit_user, rabbit_password)
    params = pika.ConnectionParameters(
        host=rabbit_host,
        port=rabbit_port,
        virtual_host="/",
        credentials=credentials,
        heartbeat=60,
        blocked_connection_timeout=300,
    )

    connection = connect_with_retry(params, logger)
    channel = connection.channel()
    channel.queue_declare(queue=rabbit_queue, durable=True)
    channel.basic_qos(prefetch_count=1)

    logger.info("Consuming queue '%s' with VK method '%s'", rabbit_queue, vk_method)

    def on_message(
        ch: pika.channel.Channel,
        method: pika.spec.Basic.Deliver,
        properties: pika.spec.BasicProperties,
        body: bytes,
    ) -> None:
        handle_message(ch, method, body, vk_token, vk_api_version, vk_method, logger)

    channel.basic_consume(queue=rabbit_queue, on_message_callback=on_message, auto_ack=False)

    try:
        channel.start_consuming()
    except KeyboardInterrupt:
        logger.info("Shutting down worker")
    finally:
        try:
            channel.stop_consuming()
        except Exception:
            pass
        connection.close()


if __name__ == "__main__":
    main()
