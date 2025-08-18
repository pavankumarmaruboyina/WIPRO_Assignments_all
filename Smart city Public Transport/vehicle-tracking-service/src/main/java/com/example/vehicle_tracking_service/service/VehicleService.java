package com.example.vehicle_tracking_service.service;

import com.example.vehicle_tracking_service.model.Vehicle;
import com.example.vehicle_tracking_service.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public List<Vehicle> findAll() {
        return repo.findAll();
    }

    public Vehicle findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
