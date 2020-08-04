package com.aca.streams.movies;

import com.aca.streams.models.Movie;
import com.aca.streams.service.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Group the movies by the year and list them
 *
 * @author: garik
 * @created: 7/30/2020, 3:06 PM
 */
public class Exercise3 {
    public static void main(String[] args) {
        Exercise3 testExercise = new Exercise3();
        System.out.print(testExercise.groupMoviesByYear_Arsen());
    }

    private List<Movie> listMoviesByYear() {
        MovieService movieService = InMemoryMovieService.getInstance();

        List<Movie> moviesByYearList = movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .sorted((movie1, movie2) -> movie1.getYear() - movie2.getYear())
                .collect(Collectors.toList());

        return moviesByYearList;
    }

    public TreeMap<Integer, List<Movie>> moviesListByYear_Armine() {
        MovieService movieService = InMemoryMovieService.getInstance();
       return movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Movie::getYear,TreeMap::new,Collectors.toList()));
    }

    public Map<Integer, List<Movie>> groupMoviesByYear_Arsen() {
        MovieService movieService = InMemoryMovieService.getInstance();
        return movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(Movie::getYear))
                .collect(Collectors.groupingBy(Movie::getYear, Collectors.toList()));
    }
}
