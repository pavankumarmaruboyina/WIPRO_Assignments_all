package com.example.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "class_created", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("Notification received class created event: " + message);
        // Logic to send notifications, store to DB, etc.
    }
}
