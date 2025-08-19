package com.example.notification_service.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "outbox")
public class Outbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private Subscription.Channel channel;

    @Lob
    private String payload; // JSON string

    private Instant scheduledAt;

    @Enumerated(EnumType.STRING)
    private Status status; // PENDING, SENT, FAILED

    public enum Status {
        PENDING, SENT, FAILED
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Subscription.Channel getChannel() { return channel; }
    public void setChannel(Subscription.Channel channel) { this.channel = channel; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }

    public Instant getScheduledAt() { return scheduledAt; }
    public void setScheduledAt(Instant scheduledAt) { this.scheduledAt = scheduledAt; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
