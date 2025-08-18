package com.example.appointment_service.service;

import com.example.appointment_service.feign.DoctorFeignClient;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.model.AppointmentConfirmedEvent;
import com.example.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorFeignClient doctorFeignClient;

    @Autowired
    private KafkaTemplate<String, AppointmentConfirmedEvent> kafkaTemplate;

    // Booking with doctor slot locking and event publishing
    public Appointment bookAppointment(Appointment appointment) {
        // Step 1: Lock doctor's slot by calling Doctor Service via Feign client
        try {
            doctorFeignClient.lockSlot(appointment.getSlotId());
        } catch (Exception e) {
            throw new ResponseStatusException(
                org.springframework.http.HttpStatus.CONFLICT,
                "Failed to lock doctor slot: " + e.getMessage()
            );
        }

        // Step 2: Save appointment in DB
        appointment.setStatus("BOOKED");
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Step 3: Publish the appointment confirmed event to Kafka
        AppointmentConfirmedEvent event = new AppointmentConfirmedEvent(savedAppointment);
        kafkaTemplate.send("appointment_confirmed", event);

        return savedAppointment;
    }

    // Retrieve all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Retrieve appointment by ID
    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    // Update appointment by ID
    public Appointment updateAppointment(String id, Appointment appointment) {
        return appointmentRepository.findById(id)
            .map(existingAppointment -> {
                existingAppointment.setPatientId(appointment.getPatientId());
                existingAppointment.setDoctorId(appointment.getDoctorId());
                existingAppointment.setSlotId(appointment.getSlotId());
                existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
                existingAppointment.setStatus(appointment.getStatus());
                return appointmentRepository.save(existingAppointment);
            })
            .orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
    }

    // Delete appointment by ID
    public void deleteAppointment(String id) {
        appointmentRepository.deleteById(id);
    }
}
