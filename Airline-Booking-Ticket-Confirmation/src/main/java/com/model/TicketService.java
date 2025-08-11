package com.model;

public class TicketService {
    private FlightService flightService;

    // Setter-based dependency injection
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Confirms booking if seats are available.
     */
    public String confirmBooking(String flightId, String userId) {
        if (flightService.hasAvailableSeats(flightId)) {
            flightService.bookSeat(flightId);
            return "Booking confirmed for " + userId + " on " + flightId;
        } else {
            return "Flight " + flightId + " is full";
        }
    }
}
