package com.example.vehicle_tracking_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VehiclePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;
    private LocalDateTime ts;
    private double lat;
    private double lon;
    private double speed;
    private int heading;
    private double accuracyM;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public LocalDateTime getTs() { return ts; }
    public void setTs(LocalDateTime ts) { this.ts = ts; }
    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }
    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }
    public int getHeading() { return heading; }
    public void setHeading(int heading) { this.heading = heading; }
    public double getAccuracyM() { return accuracyM; }
    public void setAccuracyM(double accuracyM) { this.accuracyM = accuracyM; }
}
