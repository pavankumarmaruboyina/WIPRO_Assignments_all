package com.example.route_service.service;

import com.example.route_service.event.RouteEventProducer;
import com.example.route_service.model.Route;
import com.example.route_service.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository repository;
    private final RouteEventProducer eventProducer;

    public RouteService(RouteRepository repository, RouteEventProducer eventProducer) {
        this.repository = repository;
        this.eventProducer = eventProducer;
    }

    public List<Route> findAll() {
        return repository.findAll();
    }

    public Route findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Route save(Route route) {
        Route saved = repository.save(route);
        eventProducer.sendRouteCreated(saved);
        return saved;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
