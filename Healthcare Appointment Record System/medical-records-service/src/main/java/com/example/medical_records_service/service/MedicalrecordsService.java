package com.example.medical_records_service.service;

import com.example.medical_records_service.model.Medicalrecords;
import com.example.medical_records_service.repository.MedicalrecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalrecordsService {

    @Autowired
    private MedicalrecordsRepository medicalrecordsRepository;

    public Medicalrecords createRecord(Medicalrecords record) {
        return medicalrecordsRepository.save(record);
    }

    public List<Medicalrecords> getAllRecords() {
        return medicalrecordsRepository.findAll();
    }

    public Optional<Medicalrecords> getRecordById(String id) {
        return medicalrecordsRepository.findById(id);
    }

    public List<Medicalrecords> getRecordsByPatientId(String patientId) {
        return medicalrecordsRepository.findByPatientId(patientId);
    }

    public Medicalrecords updateRecord(String id, Medicalrecords updatedRecord) {
        return medicalrecordsRepository.findById(id)
            .map(record -> {
                record.setPatientId(updatedRecord.getPatientId());
                record.setVisitDate(updatedRecord.getVisitDate());
                record.setDiagnosis(updatedRecord.getDiagnosis());
                record.setPrescription(updatedRecord.getPrescription());
                record.setTestResults(updatedRecord.getTestResults());
                return medicalrecordsRepository.save(record);
            }).orElseThrow(() -> new RuntimeException("Medical record not found"));
    }

    public void deleteRecord(String id) {
        medicalrecordsRepository.deleteById(id);
    }
}
