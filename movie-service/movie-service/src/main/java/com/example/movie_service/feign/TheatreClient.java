package com.example.movie_service.feign;

import com.example.movie_service.dto.TheatreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theatre-service")
public interface TheatreClient {
    @GetMapping("/api/theatres/{id}")
    TheatreDTO getTheatreById(@PathVariable("id") Long id);
}
