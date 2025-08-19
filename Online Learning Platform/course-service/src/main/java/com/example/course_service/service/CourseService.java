package com.example.course_service.service;

import com.example.course_service.model.Course;
import com.example.course_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // CREATE
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // READ ONE
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // UPDATE (Full)
    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(updatedCourse.getTitle());
                    course.setDescription(updatedCourse.getDescription());
                    course.setInstructor(updatedCourse.getInstructor());
                    course.setPrice(updatedCourse.getPrice());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    // PATCH
    public Course patchCourse(Long id, Course partialCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    if (partialCourse.getTitle() != null) course.setTitle(partialCourse.getTitle());
                    if (partialCourse.getDescription() != null) course.setDescription(partialCourse.getDescription());
                    if (partialCourse.getInstructor() != null) course.setInstructor(partialCourse.getInstructor());
                    if (partialCourse.getPrice() != null) course.setPrice(partialCourse.getPrice());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    // DELETE
    public String deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id " + id);
        }
        courseRepository.deleteById(id);
        return "Course with id " + id + " deleted successfully.";
    }
}
