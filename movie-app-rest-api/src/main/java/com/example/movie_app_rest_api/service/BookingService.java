package com.example.movie_app_rest_api.service;

import com.example.movie_app_rest_api.model.Booking;
import com.example.movie_app_rest_api.model.Customer;
import com.example.movie_app_rest_api.model.Movie;
import com.example.movie_app_rest_api.model.Theatre;
import com.example.movie_app_rest_api.repository.BookingRepository;
import com.example.movie_app_rest_api.repository.CustomerRepository;
import com.example.movie_app_rest_api.repository.MovieRepository;
import com.example.movie_app_rest_api.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        if (booking.getMovie() != null && booking.getMovie().getId() != null) {
            Movie movie = movieRepository.findById(booking.getMovie().getId()).orElse(null);
            booking.setMovie(movie);
        }
        if (booking.getTheatre() != null && booking.getTheatre().getId() != null) {
            Theatre theatre = theatreRepository.findById(booking.getTheatre().getId()).orElse(null);
            booking.setTheatre(theatre);
        }
        if (booking.getCustomer() != null && booking.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(booking.getCustomer().getId()).orElse(null);
            booking.setCustomer(customer);
        }
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        if (booking.getMovie() != null && booking.getMovie().getId() != null) {
            Movie movie = movieRepository.findById(booking.getMovie().getId()).orElse(null);
            booking.setMovie(movie);
        }
        if (booking.getTheatre() != null && booking.getTheatre().getId() != null) {
            Theatre theatre = theatreRepository.findById(booking.getTheatre().getId()).orElse(null);
            booking.setTheatre(theatre);
        }
        if (booking.getCustomer() != null && booking.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(booking.getCustomer().getId()).orElse(null);
            booking.setCustomer(customer);
        }
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }
}

