package org.example.moviebookingsystem;

import org.example.moviebookingsystem.constant.City;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    public MovieController() {
        this.cityVsMovies = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        allMovies.add(movie);
    }

    public void addMovieToACity(City city, Movie movie){
        List<Movie> movieList = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movieList.add(movie);
        cityVsMovies.put(city, movieList);
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.getOrDefault(city, Collections.emptyList());
    }



}
