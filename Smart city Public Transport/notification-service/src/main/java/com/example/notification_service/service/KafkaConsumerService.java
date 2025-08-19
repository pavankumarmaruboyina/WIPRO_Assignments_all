package com.example.notification_service.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "vehicle.delay-detected.v1", groupId = "notification-service")
    public void listenVehicleDelay(ConsumerRecord<String, String> record) {
        logger.info("Consumed delay event: Key={}, Value={}", record.key(), record.value());
        // Here you’d match subscriptions and schedule notifications
    }
}
