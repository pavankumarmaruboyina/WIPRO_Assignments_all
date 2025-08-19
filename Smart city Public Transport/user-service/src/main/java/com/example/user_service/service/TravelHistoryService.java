package com.example.user_service.service;

import com.example.user_service.model.TravelHistory;
import com.example.user_service.repository.TravelHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelHistoryService {

    private final TravelHistoryRepository repository;

    public TravelHistoryService(TravelHistoryRepository repository) {
        this.repository = repository;
    }

    public List<TravelHistory> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public TravelHistory save(TravelHistory travelHistory) {
        return repository.save(travelHistory);
    }
}
