package com.example.CINEMA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MovieService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> allMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> singleMovie(String imdbId) {
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
