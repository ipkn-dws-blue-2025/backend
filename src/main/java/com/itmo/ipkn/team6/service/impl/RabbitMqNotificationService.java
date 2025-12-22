package com.itmo.ipkn.team6.service.impl;

import com.itmo.ipkn.team6.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqNotificationService implements NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendNotification(String message) {
        return false;
    }
}
