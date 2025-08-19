package com.example.user_service.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "travel_history")
public class TravelHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String routeId;

    private String boardedStopId;

    private String alightedStopId;

    private Instant ts;

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getBoardedStopId() { return boardedStopId; }
    public void setBoardedStopId(String boardedStopId) { this.boardedStopId = boardedStopId; }

    public String getAlightedStopId() { return alightedStopId; }
    public void setAlightedStopId(String alightedStopId) { this.alightedStopId = alightedStopId; }

    public Instant getTs() { return ts; }
    public void setTs(Instant ts) { this.ts = ts; }
}
