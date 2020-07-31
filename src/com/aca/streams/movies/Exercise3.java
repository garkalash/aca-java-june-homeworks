package com.aca.streams.movies;

import com.aca.streams.models.Movie;
import com.aca.streams.service.InMemoryMovieService;
import com.aca.streams.service.MovieService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Group the movies by the year and list them
 *
 * @author: garik
 * @created: 7/30/2020, 3:06 PM
 */
public class Exercise3 {
    public static void main(String[] args) {

    }

    private List<Movie> listMoviesByYear() {
        MovieService movieService = InMemoryMovieService.getInstance();

        List<Movie> moviesByYearList = movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .sorted((movie1, movie2) -> movie1.getYear() - movie2.getYear())
                .collect(Collectors.toList());

        return moviesByYearList;
    }
}
