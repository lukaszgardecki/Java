package com.example.przyklad_2.application.usecases;

import com.example.przyklad_2.application.dao.MovieDAO;
import com.example.przyklad_2.application.dto.NewMovieDto;
import com.example.przyklad_2.domain.Movie;
import com.example.przyklad_2.infrastructure.exceptions.MovieAlreadyExistsException;
import com.example.przyklad_2.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieUseCase {
    private final MovieDAO movieDAO;

    public String saveMovie(NewMovieDto newMovieDto) {
        var isPresent = movieDAO.findByTitle(newMovieDto.title()).isPresent();
        if (isPresent) throw new MovieAlreadyExistsException("Movie already exists");
        movieDAO.saveMovie(newMovieDto);
        return "Movie saved";
    }

    public List<Movie>getAllMovies() {
        return movieDAO.findAll();
    }

    public String updateMovie(Movie movie) {
        var isPresent = movieDAO.findByTitle(movie.title()).isPresent();
        if (!isPresent) throw new MovieNotFoundException("This movie does not exist");
        movieDAO.updateMovie(movie);
        return "Movie updated";
    }

    public void deleteMovie(Movie movie) {
        movieDAO.deleteMovie(movie);
    }

    public Movie getMovieByTitle(String title) {
        return movieDAO.findByTitle(title).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }
}
