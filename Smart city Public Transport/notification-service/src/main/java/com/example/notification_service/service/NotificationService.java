package com.example.notification_service.service;

import com.example.notification_service.model.Outbox;
import com.example.notification_service.repository.OutboxRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class NotificationService {

    private final OutboxRepository outboxRepository;

    public NotificationService(OutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    public Outbox scheduleNotification(String userId, Outbox.Status status, Outbox outbox) {
        outbox.setUserId(userId);
        outbox.setStatus(status);
        outbox.setScheduledAt(Instant.now());
        return outboxRepository.save(outbox);
    }

    // Example: Send pending notifications (stub)
    public void processPendingNotifications() {
        List<Outbox> pending = outboxRepository.findByStatus(Outbox.Status.PENDING);
        for (Outbox outbox : pending) {
            // Here you would integrate with real push/SMS/email provider
            outbox.setStatus(Outbox.Status.SENT); // assume sent for demo
            outboxRepository.save(outbox);
        }
    }
}
