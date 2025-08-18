package com.example.vehicle_tracking_service.controller;

import com.example.vehicle_tracking_service.model.Vehicle;
import com.example.vehicle_tracking_service.model.VehiclePosition;
import com.example.vehicle_tracking_service.service.VehicleService;
import com.example.vehicle_tracking_service.service.VehiclePositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehiclePositionService positionService;

    public VehicleController(VehicleService vehicleService, VehiclePositionService positionService) {
        this.vehicleService = vehicleService;
        this.positionService = positionService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicleService.findById(id);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle existing = vehicleService.findById(id);
        existing.setFleetCode(vehicle.getFleetCode());
        existing.setRouteId(vehicle.getRouteId());
        existing.setCapacity(vehicle.getCapacity());
        existing.setFeaturesJson(vehicle.getFeaturesJson());
        return vehicleService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
    }

    @PostMapping("/{vehicleId}/telemetry")
    public VehiclePosition addPosition(@PathVariable Long vehicleId, @RequestBody VehiclePosition pos) {
        pos.setVehicleId(vehicleId);
        return positionService.save(pos);
    }

    @GetMapping("/{vehicleId}/positions")
    public List<VehiclePosition> getPositions(@PathVariable Long vehicleId) {
        return positionService.getByVehicle(vehicleId);
    }
}
