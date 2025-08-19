package com.example.assessment_service.controller;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    // CREATE
    @PostMapping
    public Assessment createAssessment(@RequestBody Assessment assessment) {
        return assessmentService.createAssessment(assessment);
    }

    // READ ALL
    @GetMapping
    public List<Assessment> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Assessment> getAssessmentById(@PathVariable Long id) {
        return assessmentService.getAssessmentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Assessment updateAssessment(@PathVariable Long id, @RequestBody Assessment updatedAssessment) {
        return assessmentService.updateAssessment(id, updatedAssessment);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Assessment patchAssessment(@PathVariable Long id, @RequestBody Assessment partialAssessment) {
        return assessmentService.patchAssessment(id, partialAssessment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        return assessmentService.deleteAssessment(id);
    }
}
