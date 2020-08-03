package com.aca.streams.movies;

import com.aca.streams.models.Director;
import com.aca.streams.models.Movie;
import com.aca.streams.service.InMemoryMovieService;
import com.aca.streams.service.MovieService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the number of movies of each director
 * assume that Director doesn't have movies
 *
 * @author: garik
 * @created: 7/30/2020, 3:05 PM
 */
public class Exercise1 {
    public static void main(String[] args) {

    }

    private Map<Director, Long> numberOfMoviesByDirector() {
        MovieService movieService = InMemoryMovieService.getInstance();

        Map<Director, Long> moviesNumber = movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .map(movie -> movie.getDirectors())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(director -> director, Collectors.counting()));

        return moviesNumber;
    }

    public Map<Director, Long> getMoviesNumberByDirector_Armine() {


        MovieService movieService = InMemoryMovieService.getInstance();
        return movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .map(Movie::getDirectors)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
