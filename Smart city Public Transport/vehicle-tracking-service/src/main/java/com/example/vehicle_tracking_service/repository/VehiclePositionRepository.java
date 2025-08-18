package com.example.vehicle_tracking_service.repository;

import com.example.vehicle_tracking_service.model.VehiclePosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiclePositionRepository extends JpaRepository<VehiclePosition, Long> {
    List<VehiclePosition> findByVehicleIdOrderByTsDesc(Long vehicleId);
}
