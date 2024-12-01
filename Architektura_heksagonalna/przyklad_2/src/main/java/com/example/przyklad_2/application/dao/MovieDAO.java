package com.example.przyklad_2.application.dao;

import com.example.przyklad_2.application.dto.NewMovieDto;
import com.example.przyklad_2.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {

    Optional<Movie> findByTitle(String title);
    List<Movie> findAll();
    void saveMovie(NewMovieDto movie);
    void updateMovie(Movie movie);
    void deleteMovie(Movie movie);
}
