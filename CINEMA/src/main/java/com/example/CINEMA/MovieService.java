package com.example.CINEMA;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private moviesRespository movieRespository;
     public List<Movies> allMovies(){
         return movieRespository.findAll();
     }
     public Optional<Movies> singleMovie(String imdbId){
         return movieRespository.findMovieByImdbId(imdbId);
     }
}
