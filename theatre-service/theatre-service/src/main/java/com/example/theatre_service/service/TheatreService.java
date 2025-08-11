package com.example.theatre_service.service;

import com.example.theatre_service.model.Theatre;
import com.example.theatre_service.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id).orElse(null);
    }

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Long id, Theatre theatre) {
        theatre.setId(id);
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }
}
