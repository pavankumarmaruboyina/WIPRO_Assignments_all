package com.example.vehicle_tracking_service.repository;

import com.example.vehicle_tracking_service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}
