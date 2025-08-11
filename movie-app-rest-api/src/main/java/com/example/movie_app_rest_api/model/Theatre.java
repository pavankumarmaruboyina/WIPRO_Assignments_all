package com.example.movie_app_rest_api.model;
import jakarta.persistence.*;
import java.util.List;
@Entity

public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    
    @ManyToMany(mappedBy = "theaters")
    private List<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", location=" + location + ", movies=" + movies + "]";
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

    
}
