package com.example.ticketing_service.service;

import com.example.ticketing_service.model.Ticket;
import com.example.ticketing_service.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final KafkaProducerService kafkaProducerService;

    public TicketService(TicketRepository ticketRepository, KafkaProducerService kafkaProducerService) {
        this.ticketRepository = ticketRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public Ticket purchaseTicket(Ticket ticket) {
        ticket.setStatus("purchased");
        ticket.setIssuedAt(Instant.now());
        Ticket savedTicket = ticketRepository.save(ticket);
        kafkaProducerService.publishTicketPurchasedEvent(savedTicket);
        return savedTicket;
    }

    public List<Ticket> getUserTickets(String userId) {
        return ticketRepository.findByUserId(userId);
    }
}
