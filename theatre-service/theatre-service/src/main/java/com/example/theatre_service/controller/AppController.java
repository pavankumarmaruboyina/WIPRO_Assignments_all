package com.example.theatre_service.controller;

import com.example.theatre_service.model.Theatre;
import com.example.theatre_service.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class AppController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public List<Theatre> getAll() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @PostMapping
    public Theatre create(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @PutMapping("/{id}")
    public Theatre update(@PathVariable Long id, @RequestBody Theatre theatre) {
        return theatreService.updateTheatre(id, theatre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
    }
}
