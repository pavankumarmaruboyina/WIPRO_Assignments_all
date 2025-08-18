package com.example.doctor_service.repository;

import com.example.doctor_service.model.DoctorSlot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorSlotRepository extends MongoRepository<DoctorSlot, String> {
    List<DoctorSlot> findByDoctorIdAndStartTimeBetween(String doctorId, LocalDateTime start, LocalDateTime end);
    List<DoctorSlot> findByDoctorId(String doctorId);
}
