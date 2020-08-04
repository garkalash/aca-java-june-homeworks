package com.aca.streams.movies;

import com.aca.streams.models.*;
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
        Exercise2 testExercise = new Exercise2();
        System.out.println(testExercise.moviesByGenre_Arsen());
    }

    public List<Movie> moviesByGenre_Arsen() {
        MovieService movieService = InMemoryMovieService.getInstance();
            Genre drama = new Genre(2,"Drama");
            Genre comedy = new Genre(1,"Comedy");
            return movieService.findAllMovies().stream()
                    .filter(Objects::nonNull)
                    .filter(movie -> movie.getGenres().contains(drama) && movie.getGenres().contains(comedy))
                    .collect(Collectors.toList());
    }
}

