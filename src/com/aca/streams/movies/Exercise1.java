package com.aca.streams.movies;

import com.aca.streams.models.*;
import com.aca.streams.service.*;

import java.util.Collection;
import java.util.Map;
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
        Exercise1 testExcersize = new Exercise1();
        System.out.println(testExcersize.numberOfMoviesByDirector());
    }

    public Map<Director, Long> numberOfMoviesByDirector () {
        MovieService movieService = InMemoryMovieService.getInstance();
        return movieService.findAllMovies().stream()
                .map(Movie::getDirectors)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(director -> director, Collectors.counting() ));
    }
}
