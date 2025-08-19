package com.example.ticketing_service.dto;

import java.time.Instant;

public record TicketPurchasedEvent(
        String ticketId,
        String userId,
        String routeId,
        Double fare,
        String currency,
        Instant ts
) {}
