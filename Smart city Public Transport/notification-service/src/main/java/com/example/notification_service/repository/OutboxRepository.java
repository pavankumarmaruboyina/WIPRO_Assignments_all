package com.example.notification_service.repository;

import com.example.notification_service.model.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {
    List<Outbox> findByStatus(Outbox.Status status);
}
