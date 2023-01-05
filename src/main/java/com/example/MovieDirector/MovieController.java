package com.example.MovieDirector;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    // Creating a Movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }


    // Creating a Director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    // Adding movie-director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    // Getting Director name from movie name
    @GetMapping("/get-director-name-by-movie-name/{movie}")
    public ResponseEntity<String> getDirectorNameByMovieName(@PathVariable String movie){
        String director = movieService.getDirectorNameByMovieName(movie);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }


}
