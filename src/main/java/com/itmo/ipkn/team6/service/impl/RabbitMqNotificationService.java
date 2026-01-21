package com.itmo.ipkn.team6.service.impl;

import com.itmo.ipkn.team6.service.NotificationService;
import com.itmo.ipkn.team6.util.RabbitQueueConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMqNotificationService implements NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendNotification(String message) {
        log.info("Publishing notification to RabbitMQ queue '{}'", RabbitQueueConfiguration.NOTIFICATION_QUEUE);
        log.debug("Notification payload: {}", message);
        rabbitTemplate.convertAndSend(RabbitQueueConfiguration.NOTIFICATION_QUEUE, message);
    }
}
