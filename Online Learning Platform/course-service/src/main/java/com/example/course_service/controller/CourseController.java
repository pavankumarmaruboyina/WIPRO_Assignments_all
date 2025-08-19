package com.example.course_service.controller;

import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // CREATE
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // READ ALL
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Course patchCourse(@PathVariable Long id, @RequestBody Course partialCourse) {
        return courseService.patchCourse(id, partialCourse);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
