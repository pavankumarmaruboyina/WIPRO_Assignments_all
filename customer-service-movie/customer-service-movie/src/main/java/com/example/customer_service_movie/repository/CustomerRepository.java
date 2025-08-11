package com.example.customer_service_movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer_service_movie.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
