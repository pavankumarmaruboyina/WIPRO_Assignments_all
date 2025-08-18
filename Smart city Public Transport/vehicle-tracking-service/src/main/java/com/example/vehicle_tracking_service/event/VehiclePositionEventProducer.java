package com.example.vehicle_tracking_service.event;

import com.example.vehicle_tracking_service.model.VehiclePosition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class VehiclePositionEventProducer {
    private final KafkaTemplate<String, VehiclePosition> kafkaTemplate;

    public VehiclePositionEventProducer(KafkaTemplate<String, VehiclePosition> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPositionUpdated(VehiclePosition position) {
        kafkaTemplate.send("vehicle.position.v1", position.getVehicleId().toString(), position);
    }
}
