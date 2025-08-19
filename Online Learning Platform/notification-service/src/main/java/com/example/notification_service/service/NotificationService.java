package com.example.notification_service.service;

import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // CREATE
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // READ ALL
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // READ ONE
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // UPDATE (Full)
    public Notification updateNotification(Long id, Notification updatedNotification) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setRecipient(updatedNotification.getRecipient());
                    notification.setMessage(updatedNotification.getMessage());
                    notification.setTimestamp(updatedNotification.getTimestamp());
                    notification.setReadStatus(updatedNotification.isReadStatus());
                    return notificationRepository.save(notification);
                })
                .orElseThrow(() -> new RuntimeException("Notification not found with id " + id));
    }

    // PATCH (Partial)
    public Notification patchNotification(Long id, Notification partialNotification) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    if (partialNotification.getRecipient() != null)
                        notification.setRecipient(partialNotification.getRecipient());
                    if (partialNotification.getMessage() != null)
                        notification.setMessage(partialNotification.getMessage());
                    if (partialNotification.getTimestamp() != null)
                        notification.setTimestamp(partialNotification.getTimestamp());
                    notification.setReadStatus(partialNotification.isReadStatus());
                    return notificationRepository.save(notification);
                })
                .orElseThrow(() -> new RuntimeException("Notification not found with id " + id));
    }

    // DELETE
    public String deleteNotification(Long id) {
        if (!notificationRepository.existsById(id)) {
            throw new RuntimeException("Notification not found with id " + id);
        }
        notificationRepository.deleteById(id);
        return "Notification with id " + id + " deleted successfully.";
    }
}
