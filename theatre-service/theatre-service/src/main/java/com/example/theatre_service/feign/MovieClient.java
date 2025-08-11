package com.example.theatre_service.feign;

import com.example.theatre_service.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/api/movies/{id}")
    MovieDTO getMovieById(@PathVariable("id") Long id);
}
