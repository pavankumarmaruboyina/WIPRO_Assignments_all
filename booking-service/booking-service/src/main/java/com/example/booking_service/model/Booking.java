package com.example.booking_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // IDs from other services
    private Long movieId;
    private Long theatreId;
    private Long customerId;

    private int seats;
    private LocalDateTime bookingDate;

    public Booking() {}

    public Booking(Long id, Long movieId, Long theatreId, Long customerId, int seats, LocalDateTime bookingDate) {
        this.id = id;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.customerId = customerId;
        this.seats = seats;
        this.bookingDate = bookingDate;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Long getTheatreId() { return theatreId; }
    public void setTheatreId(Long theatreId) { this.theatreId = theatreId; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
}
