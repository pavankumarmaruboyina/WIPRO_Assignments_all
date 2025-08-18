package com.example.notification_service.listener;

import com.example.notification_service.model.AppointmentConfirmedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConfirmedListener {

    @KafkaListener(topics = "appointment_confirmed", groupId = "notification-group",
                   containerFactory = "kafkaListenerContainerFactory")
    public void onAppointmentConfirmed(AppointmentConfirmedEvent event) {
        // Simulate sending notification (SMS/Email)
        System.out.println("Received appointment confirmed event: " + event);

        // Insert any real notification logic here (email, SMS gateway, etc.)
        System.out.println("Sending notification to patient " + event.getPatientId() + " for appointment " + event.getAppointmentId());
    }
}
