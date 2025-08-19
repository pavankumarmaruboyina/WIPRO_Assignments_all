package com.example.notification_service.controller;

import com.example.notification_service.model.Subscription;
import com.example.notification_service.repository.SubscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionRepository repository;

    public SubscriptionController(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Subscription subscribe(@RequestBody Subscription subscription) {
        return repository.save(subscription);
    }

    @GetMapping("/user/{userId}")
    public List<Subscription> getSubscriptions(@PathVariable String userId) {
        return repository.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> unsubscribe(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
