package com.example.CINEMA.controller;

import com.example.CINEMA.model.Movies;
import com.example.CINEMA.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movies>> allMovies() {
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMovie(@RequestBody Movies movies) {
        movieService.createMovie(movies);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie is created successfully");
    }
}

