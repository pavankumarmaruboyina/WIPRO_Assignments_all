package com.example.movie_service.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;

    /**
     * Instead of ManyToMany with Theatre entity,
     * store just the IDs of theatres from the Theatre microservice.
     * This preserves microservice separation.
     */
    @ElementCollection
    @CollectionTable(
        name = "movie_theatre_mapping",
        joinColumns = @JoinColumn(name = "movie_id")
    )
    @Column(name = "theatre_id")
    private List<Long> theatreIds;

    public Movie() {}

    public Movie(String title, String genre, List<Long> theatreIds) {
        this.title = title;
        this.genre = genre;
        this.theatreIds = theatreIds;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public List<Long> getTheatreIds() { return theatreIds; }
    public void setTheatreIds(List<Long> theatreIds) { this.theatreIds = theatreIds; }
}
