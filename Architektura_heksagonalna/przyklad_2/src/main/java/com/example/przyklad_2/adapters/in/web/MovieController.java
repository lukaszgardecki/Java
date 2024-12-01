package com.example.przyklad_2.adapters.in.web;

import com.example.przyklad_2.application.dto.NewMovieDto;
import com.example.przyklad_2.application.usecases.MovieUseCase;
import com.example.przyklad_2.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @GetMapping("/save")
    public ResponseEntity<?> saveMovie(@RequestBody NewMovieDto newMovieDto) {
        return ResponseEntity.status(201).body(movieUseCase.saveMovie(newMovieDto));
    }

    @PutMapping
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(201).body(movieUseCase.updateMovie(movie));
    }
}
