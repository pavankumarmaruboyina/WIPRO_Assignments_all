package com.example.route_service.controller;

import com.example.route_service.model.Route;
import com.example.route_service.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Route> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Route getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Route create(@RequestBody Route route) {
        return service.save(route);
    }

    @PutMapping("/{id}")
    public Route update(@PathVariable Long id, @RequestBody Route route) {
        Route existing = service.findById(id);
        existing.setName(route.getName());
        existing.setActive(route.isActive());
        existing.setMode(route.getMode());
        existing.setAgencyId(route.getAgencyId());
        existing.setStops(route.getStops());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
