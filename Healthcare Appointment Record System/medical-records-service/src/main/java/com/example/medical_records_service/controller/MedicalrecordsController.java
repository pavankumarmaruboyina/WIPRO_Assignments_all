package com.example.medical_records_service.controller;

import com.example.medical_records_service.model.Medicalrecords;
import com.example.medical_records_service.service.MedicalrecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalrecordsController {

    @Autowired
    private MedicalrecordsService medicalrecordsService;

    @PostMapping
    public ResponseEntity<Medicalrecords> createRecord(@RequestBody Medicalrecords record) {
        Medicalrecords saved = medicalrecordsService.createRecord(record);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Medicalrecords>> getAllRecords() {
        return ResponseEntity.ok(medicalrecordsService.getAllRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicalrecords> getRecordById(@PathVariable String id) {
        return medicalrecordsService.getRecordById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Medicalrecords>> getRecordsByPatientId(@PathVariable String patientId) {
        return ResponseEntity.ok(medicalrecordsService.getRecordsByPatientId(patientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicalrecords> updateRecord(@PathVariable String id, @RequestBody Medicalrecords record) {
        try {
            Medicalrecords updated = medicalrecordsService.updateRecord(id, record);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable String id) {
        medicalrecordsService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
