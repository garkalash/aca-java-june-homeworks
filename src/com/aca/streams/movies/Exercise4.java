package com.aca.streams.movies;

import com.aca.streams.models.Genre;
import com.aca.streams.models.Movie;
import com.aca.streams.service.InMemoryMovieService;
import com.aca.streams.service.MovieService;


import java.util.*;

import java.util.stream.Collectors;

/**
 * group movies by genre
 *
 * @author: garik
 * @created: 7/30/2020, 3:14 PM
 */
public class Exercise4 {
    public static void main(String[] args) {

    }

    private Map<Genre, Movie> sortByGroupId() {
        MovieService movieService = InMemoryMovieService.getInstance();

        Set<Genre> genreList = movieService.findAllMovies().stream()
                .filter(Objects::nonNull)
                .map(movie -> movie.getGenres())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        Map<Genre, Movie> movieGenreMap = new HashMap<>();

        genreList.forEach(genre->movieService.findAllMovies().forEach(movie -> {
                    if (movie.getGenres().contains(genre)) {
                        movieGenreMap.put(genre, movie);
                    }
                }
        ));

        return movieGenreMap;
    }
}
