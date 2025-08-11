package com.example.theatre_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.theatre_service.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
