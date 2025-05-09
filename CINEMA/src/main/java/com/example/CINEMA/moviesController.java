package com.example.CINEMA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class moviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Movies>> allMovies(){
        return  new ResponseEntity<List<Movies>>(movieService.allMovies(),HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public  ResponseEntity<Optional<Movies>> getsingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(movieService.singleMovie(imdbId),HttpStatus.OK);
    }
}

