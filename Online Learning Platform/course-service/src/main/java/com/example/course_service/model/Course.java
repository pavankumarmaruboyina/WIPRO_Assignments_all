package com.example.course_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course title is required")
    @Size(min = 3, message = "Course title must be at least 3 characters")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String instructor;

    private Double price;

    public Course() {}

    public Course(String title, String description, String instructor, Double price) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.price = price;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
