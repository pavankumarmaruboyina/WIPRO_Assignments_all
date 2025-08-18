package com.example.route_service.event;

import com.example.route_service.model.Route;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RouteEventProducer {

    private final KafkaTemplate<String, Route> kafkaTemplate;

    public RouteEventProducer(KafkaTemplate<String, Route> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRouteCreated(Route route) {
        kafkaTemplate.send("route.created.v1", route.getId().toString(), route);
    }
}
