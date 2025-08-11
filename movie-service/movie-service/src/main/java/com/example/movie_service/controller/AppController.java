package com.example.movie_service.controller;

import com.example.movie_service.model.Movie;
import com.example.movie_service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class AppController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
