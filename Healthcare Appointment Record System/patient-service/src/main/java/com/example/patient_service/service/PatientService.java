package com.example.patient_service.service;

import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(String id, Patient updatedPatient) {
        return patientRepository.findById(id)
            .map(patient -> {
                patient.setFirstName(updatedPatient.getFirstName());
                patient.setLastName(updatedPatient.getLastName());
                patient.setEmail(updatedPatient.getEmail());
                patient.setPhoneNumber(updatedPatient.getPhoneNumber());
                patient.setInsuranceProvider(updatedPatient.getInsuranceProvider());
                patient.setInsuranceNumber(updatedPatient.getInsuranceNumber());
                return patientRepository.save(patient);
            })
            .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
