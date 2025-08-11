package com.example.movie_app_rest_api.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.movie_app_rest_api.model.Movie;
import com.example.movie_app_rest_api.repository.MovieRepository;

@SpringBootTest
class MovieServiceTest {
@Mock
MovieRepository movierepository;
@InjectMocks
MovieService movieservice;

private Movie movie;


@BeforeEach
void setUp() {
    movie = new Movie();
    movie.setId(1L);
    movie.setTitle("Inception");
    movie.setGenre("Sci-Fi");
}

@Test
void testCreateMovie() {
    // Stubbing: whenever save is called, return our movie
    Mockito.when(movierepository.save(Mockito.any(Movie.class))).thenReturn(movie);

    // Action
    Movie savedMovie = movieservice.createMovie(movie);

    // Assert
    assertNotNull(savedMovie);
    assertEquals("Inception", savedMovie.getTitle());
    assertEquals("Sci-Fi", savedMovie.getGenre());
}


	@Test
	void test() {
		fail("Not yet implemented");
	}

}
