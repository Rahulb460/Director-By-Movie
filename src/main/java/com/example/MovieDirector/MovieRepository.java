package com.example.MovieDirector;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, String> movieDirector;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.movieDirector = new HashMap<String, String>();
    }

    // Putting movie in movie's Map
    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }


    // Putting Director in director's Map
    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }


    // Putting movie as key and director as value in movie-director map
    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieDirector.put(movie, director);
        }
    }

    // Getting the Director Name from Movie name
    public String getDirectorNameByMovieName(String movie) {
        return movieDirector.get(movie);
    }

}
