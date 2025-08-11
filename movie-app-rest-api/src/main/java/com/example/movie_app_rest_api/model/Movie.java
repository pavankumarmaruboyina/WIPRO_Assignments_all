package com.example.movie_app_rest_api.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    
    @ManyToMany
    @JoinTable(
      name = "movie_theater", 
      joinColumns = @JoinColumn(name = "movie_id"), 
      inverseJoinColumns = @JoinColumn(name = "theater_id"))
    private List<Theatre> theaters;

    
    public List<Theatre> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<Theatre> theaters) {
		this.theaters = theaters;
	}

	public Movie() {}

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}