package com.itmo.ipkn.team6.util;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueConfiguration {

    public static final String NOTIFICATION_QUEUE = "notification_queue";

    @Bean
    public Queue myQueue() {
        return new Queue(NOTIFICATION_QUEUE, true);
    }
}
