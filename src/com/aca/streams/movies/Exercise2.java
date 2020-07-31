package com.aca.streams.movies;

import com.aca.streams.models.Genre;
import com.aca.streams.models.Movie;
import com.aca.streams.service.InMemoryMovieService;
import com.aca.streams.service.MovieService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Find the list of movies having the genres "Drama" and "Comedy" only
 *
 * @author: garik
 * @created: 7/30/2020, 3:06 PM
 */
public class Exercise2 {
    public static void main(String[] args) {

    }

    private List<Movie> listOfDramaAndComedy() {
        MovieService movieService = InMemoryMovieService.getInstance();

        List<Movie> moviesDramaComedyList = movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .filter(movie -> movie.getGenres().contains(new Genre(2, "Drama")) && movie.getGenres().contains(new Genre(1,"Comedy")))
                .collect(Collectors.toList());

        return moviesDramaComedyList;
    }
}
