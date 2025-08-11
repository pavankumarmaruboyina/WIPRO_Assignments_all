package com.example.movie_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_app_rest_api.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
