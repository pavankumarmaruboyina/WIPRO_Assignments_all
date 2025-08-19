package com.example.notification_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private Channel channel; // PUSH, SMS, EMAIL

    private String routeId;
    private String stopId;

    public enum Channel {
        PUSH, SMS, EMAIL
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Channel getChannel() { return channel; }
    public void setChannel(Channel channel) { this.channel = channel; }

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getStopId() { return stopId; }
    public void setStopId(String stopId) { this.stopId = stopId; }
}
