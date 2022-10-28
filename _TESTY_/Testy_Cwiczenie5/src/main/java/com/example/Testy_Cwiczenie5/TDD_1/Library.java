package com.example.Testy_Cwiczenie5.TDD_1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Movie> catalogue = new ArrayList<>();

    public void donate(Movie movie) {
        catalogue.add(movie);
        movie.addCopy();
    }

    public boolean contains(Movie movie) {
        return catalogue.contains(movie);
    }
}
