package com.example.classroom_service.service;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    // CREATE
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    // READ ALL
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    // READ ONE
    public Optional<Classroom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    // UPDATE
    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        return classroomRepository.findById(id)
                .map(classroom -> {
                    classroom.setName(updatedClassroom.getName());
                    classroom.setCourseId(updatedClassroom.getCourseId());
                    classroom.setInstructor(updatedClassroom.getInstructor());
                    classroom.setStartTime(updatedClassroom.getStartTime());
                    classroom.setEndTime(updatedClassroom.getEndTime());
                    return classroomRepository.save(classroom);
                })
                .orElseThrow(() -> new RuntimeException("Classroom not found with id " + id));
    }

    // PATCH
    public Classroom patchClassroom(Long id, Classroom partialClassroom) {
        return classroomRepository.findById(id)
                .map(classroom -> {
                    if (partialClassroom.getName() != null) classroom.setName(partialClassroom.getName());
                    if (partialClassroom.getCourseId() != null) classroom.setCourseId(partialClassroom.getCourseId());
                    if (partialClassroom.getInstructor() != null) classroom.setInstructor(partialClassroom.getInstructor());
                    if (partialClassroom.getStartTime() != null) classroom.setStartTime(partialClassroom.getStartTime());
                    if (partialClassroom.getEndTime() != null) classroom.setEndTime(partialClassroom.getEndTime());
                    return classroomRepository.save(classroom);
                })
                .orElseThrow(() -> new RuntimeException("Classroom not found with id " + id));
    }

    // DELETE
    public String deleteClassroom(Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new RuntimeException("Classroom not found with id " + id);
        }
        classroomRepository.deleteById(id);
        return "Classroom with id " + id + " deleted successfully.";
    }
}
