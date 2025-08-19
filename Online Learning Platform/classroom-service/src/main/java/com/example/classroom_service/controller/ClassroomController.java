package com.example.classroom_service.controller;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.service.ClassroomService;
import com.example.classroom_service.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private KafkaProducer kafkaProducer;

    // CREATE Classroom
    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        Classroom saved = classroomService.createClassroom(classroom);
        // Send Kafka event on creation
        String kafkaMessage = String.format("{\"classId\":%d,\"name\":\"%s\",\"instructor\":\"%s\"}", saved.getId(), saved.getName(), saved.getInstructor());
        kafkaProducer.sendMessage(kafkaMessage);
        return saved;
    }

    // GET all classrooms
    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    // GET single classroom
    @GetMapping("/{id}")
    public Optional<Classroom> getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    // UPDATE classroom (full)
    @PutMapping("/{id}")
    public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom updatedClassroom) {
        return classroomService.updateClassroom(id, updatedClassroom);
    }

    // PATCH classroom (partial)
    @PatchMapping("/{id}")
    public Classroom patchClassroom(@PathVariable Long id, @RequestBody Classroom partialClassroom) {
        return classroomService.patchClassroom(id, partialClassroom);
    }

    // DELETE classroom
    @DeleteMapping("/{id}")
    public String deleteClassroom(@PathVariable Long id) {
        return classroomService.deleteClassroom(id);
    }
}
