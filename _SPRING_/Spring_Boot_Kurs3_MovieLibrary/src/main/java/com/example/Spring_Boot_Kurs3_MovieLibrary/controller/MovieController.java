package com.example.Spring_Boot_Kurs3_MovieLibrary.controller;

import com.example.Spring_Boot_Kurs3_MovieLibrary.model.Movie;
import com.example.Spring_Boot_Kurs3_MovieLibrary.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @GetMapping("/{id}")
    // @PathVariable oznacza, że chcemy "wsadzić" od tej metody to co wpiszemy po ostatnim slashu
    public Movie getById(@PathVariable int id) {
        return movieRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Movie updatedMovie, @PathVariable("id") int id) {
        Movie movie = movieRepository.getById(id);

        if (movie != null) {
            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());

            movieRepository.update(movie);

            return 1;
        } else {
            return -1;
        }
    }


    // umożliwia edycję POJEDYNCZYCH pól rekordu
    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);

        if (movie != null) {
            if (updatedMovie.getName() != null) movie.setName(updatedMovie.getName());
            if (updatedMovie.getRating() > 0) movie.setRating(updatedMovie.getRating());

            return movieRepository.update(movie);
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id) {
        return movieRepository.delete(id);

    }
}
