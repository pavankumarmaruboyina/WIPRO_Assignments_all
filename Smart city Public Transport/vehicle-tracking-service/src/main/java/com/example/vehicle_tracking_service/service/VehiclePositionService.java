package com.example.vehicle_tracking_service.service;

import com.example.vehicle_tracking_service.event.VehiclePositionEventProducer;
import com.example.vehicle_tracking_service.model.VehiclePosition;
import com.example.vehicle_tracking_service.repository.VehiclePositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclePositionService {

    private final VehiclePositionRepository repo;
    private final VehiclePositionEventProducer eventProducer;

    public VehiclePositionService(VehiclePositionRepository repo, VehiclePositionEventProducer eventProducer) {
        this.repo = repo;
        this.eventProducer = eventProducer;
    }

    public VehiclePosition save(VehiclePosition pos) {
        VehiclePosition saved = repo.save(pos);
        eventProducer.sendPositionUpdated(saved);
        return saved;
    }

    public List<VehiclePosition> getByVehicle(Long vehicleId) {
        return repo.findByVehicleIdOrderByTsDesc(vehicleId);
    }
}
