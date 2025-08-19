package com.example.assessment_service.service;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    // CREATE
    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    // READ ALL
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    // READ ONE
    public Optional<Assessment> getAssessmentById(Long id) {
        return assessmentRepository.findById(id);
    }

    // UPDATE (Full)
    public Assessment updateAssessment(Long id, Assessment updatedAssessment) {
        return assessmentRepository.findById(id)
                .map(assessment -> {
                    assessment.setTitle(updatedAssessment.getTitle());
                    assessment.setDescription(updatedAssessment.getDescription());
                    assessment.setCourseId(updatedAssessment.getCourseId());
                    assessment.setTotalMarks(updatedAssessment.getTotalMarks());
                    assessment.setDueDate(updatedAssessment.getDueDate());
                    return assessmentRepository.save(assessment);
                })
                .orElseThrow(() -> new RuntimeException("Assessment not found with id " + id));
    }

    // PATCH (Partial)
    public Assessment patchAssessment(Long id, Assessment partialAssessment) {
        return assessmentRepository.findById(id)
                .map(assessment -> {
                    if (partialAssessment.getTitle() != null) assessment.setTitle(partialAssessment.getTitle());
                    if (partialAssessment.getDescription() != null) assessment.setDescription(partialAssessment.getDescription());
                    if (partialAssessment.getCourseId() != null) assessment.setCourseId(partialAssessment.getCourseId());
                    if (partialAssessment.getTotalMarks() != null) assessment.setTotalMarks(partialAssessment.getTotalMarks());
                    if (partialAssessment.getDueDate() != null) assessment.setDueDate(partialAssessment.getDueDate());
                    return assessmentRepository.save(assessment);
                })
                .orElseThrow(() -> new RuntimeException("Assessment not found with id " + id));
    }

    // DELETE
    public String deleteAssessment(Long id) {
        if (!assessmentRepository.existsById(id)) {
            throw new RuntimeException("Assessment not found with id " + id);
        }
        assessmentRepository.deleteById(id);
        return "Assessment with id " + id + " deleted successfully.";
    }
}
