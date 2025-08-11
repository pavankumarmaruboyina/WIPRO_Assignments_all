package com.example.movie_app_rest_api.controller;

import com.example.movie_app_rest_api.model.Booking;
import com.example.movie_app_rest_api.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getByCustomer(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }
}

