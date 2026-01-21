import json
import logging
import os
import time
from typing import Any, Dict, Optional

import pika
import requests


VK_API_URL = "https://api.vk.com/method/notifications.sendMessage"


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
    user_id: str,
    message: str,
    token: str,
    api_version: str,
    logger: logging.Logger,
) -> Dict[str, Any]:
    response = requests.post(
        VK_API_URL,
        data={
            "user_ids": user_id,
            "message": message,
            "access_token": token,
            "v": api_version,
        },
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
    logger: logging.Logger,
) -> None:
    try:
        payload = json.loads(body.decode("utf-8"))
    except Exception:
        logger.exception("Failed to parse message: %s", body)
        ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    user_id = payload.get("userId") or payload.get("user_id")
    message_text = build_message_text(payload)

    if not user_id or not message_text:
        logger.error("Message missing user_id or text: %s", payload)
        ch.basic_ack(delivery_tag=method.delivery_tag)
        return

    try:
        response = send_vk_notification(
            user_id=str(user_id),
            message=message_text,
            token=token,
            api_version=api_version,
            logger=logger,
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

    logger.info("Notification delivered to user_id=%s", user_id)
    ch.basic_ack(delivery_tag=method.delivery_tag)


def main() -> None:
    rabbit_host = os.getenv("RABBIT_HOST", "localhost")
    rabbit_port = int(os.getenv("RABBIT_PORT", "5672"))
    rabbit_user = os.getenv("RABBIT_USERNAME", "guest")
    rabbit_password = os.getenv("RABBIT_PASSWORD", "guest")
    rabbit_queue = os.getenv("RABBIT_QUEUE", "notification_queue")

    vk_token = os.getenv("VK_SERVICE_TOKEN")
    vk_api_version = os.getenv("VK_API_VERSION", "5.199")

    log_file = os.getenv("LOG_FILE", "logs/notification_worker.log")
    logger = setup_logger(log_file)

    if not vk_token:
        logger.error("VK_SERVICE_TOKEN is not set, exiting.")
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

    logger.info("Consuming queue '%s'", rabbit_queue)

    def on_message(
        ch: pika.channel.Channel,
        method: pika.spec.Basic.Deliver,
        properties: pika.spec.BasicProperties,
        body: bytes,
    ) -> None:
        handle_message(ch, method, body, vk_token, vk_api_version, logger)

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
