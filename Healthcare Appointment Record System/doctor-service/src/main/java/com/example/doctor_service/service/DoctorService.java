package com.example.doctor_service.service;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctor(String id, Doctor updated) {
        return doctorRepository.findById(id)
            .map(doc -> {
                doc.setName(updated.getName());
                doc.setSpecialization(updated.getSpecialization());
                doc.setEmail(updated.getEmail());
                doc.setPhoneNumber(updated.getPhoneNumber());
                return doctorRepository.save(doc);
            })
            .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}
