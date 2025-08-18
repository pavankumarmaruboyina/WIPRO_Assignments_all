package com.example.appointment_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic appointmentConfirmedTopic() {
        return new NewTopic("appointment_confirmed", 1, (short) 1);
    }
}
