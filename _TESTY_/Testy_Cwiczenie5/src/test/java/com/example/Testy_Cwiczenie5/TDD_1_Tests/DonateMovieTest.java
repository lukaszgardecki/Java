package com.example.Testy_Cwiczenie5.TDD_1_Tests;

import com.example.Testy_Cwiczenie5.TDD_1.Library;
import com.example.Testy_Cwiczenie5.TDD_1.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonateMovieTest {
    private final Library library;
    private final Movie movie;

    public DonateMovieTest() {
        library = new Library();
        movie = new Movie();
    }

    @Test
    @DisplayName("Check a library has a movie")
    public void movieAddedToCatalogue() {
        library.donate(movie);
        assertTrue(library.contains(movie));
    }

    @Test
    public void rentalCopyAdded() {
        library.donate(movie);
        assertEquals(1, movie.getCopies());
    }
}
