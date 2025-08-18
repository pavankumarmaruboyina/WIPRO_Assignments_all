package com.example.doctor_service.repository;

import com.example.doctor_service.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {}
