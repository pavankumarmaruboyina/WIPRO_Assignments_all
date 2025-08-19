package com.example.notification_service.controller;

import com.example.notification_service.model.Notification;
import com.example.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // CREATE
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    // READ ALL
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Notification> getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification updatedNotification) {
        return notificationService.updateNotification(id, updatedNotification);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Notification patchNotification(@PathVariable Long id, @RequestBody Notification partialNotification) {
        return notificationService.patchNotification(id, partialNotification);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        return notificationService.deleteNotification(id);
    }
}
