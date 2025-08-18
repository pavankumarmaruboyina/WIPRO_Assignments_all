package com.example.medical_records_service.repository;

import com.example.medical_records_service.model.Medicalrecords;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalrecordsRepository extends MongoRepository<Medicalrecords, String> {
    List<Medicalrecords> findByPatientId(String patientId);
}
