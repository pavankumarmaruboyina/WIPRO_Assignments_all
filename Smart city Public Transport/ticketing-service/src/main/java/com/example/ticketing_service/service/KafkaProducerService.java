package com.example.ticketing_service.service;

import com.example.ticketing_service.dto.TicketPurchasedEvent;
import com.example.ticketing_service.model.Ticket;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, TicketPurchasedEvent> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, TicketPurchasedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTicketPurchasedEvent(Ticket ticket) {
        TicketPurchasedEvent event = new TicketPurchasedEvent(
                String.valueOf(ticket.getId()),
                ticket.getUserId(),
                ticket.getRouteId(),
                ticket.getFare(),
                ticket.getCurrency(),
                Instant.now()
        );
        kafkaTemplate.send("ticket.purchased.v1", event.ticketId(), event);
    }
}
