package com.example.Testy_Cwiczenie5.TDD_5_Tests;


import com.example.Testy_Cwiczenie5.TDD_5.EmailServer;
import com.example.Testy_Cwiczenie5.TDD_5.Library;
import com.example.Testy_Cwiczenie5.TDD_5.Movie;
import com.example.Testy_Cwiczenie5.TDD_5.MovieInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void donateMovieAddedToCatalogueWithImdbInfo() {
        String imdbId = "tt12345";
        String title = "The Abyss";
        int year = 1989;
        MovieInfo movieInfo = new StubMovieInfo(title, year);
        Library library = new Library(movieInfo, mock(EmailServer.class));
        library.donate(imdbId);
        Movie movie = library.findMovie(imdbId);
        Assertions.assertEquals(title, movie.getTitle());
        Assertions.assertEquals(year, movie.getYear());
    }

    @Test
    public void membersEmailedAboutDonatedTitle() {
        EmailServer emailServer = mock(EmailServer.class);
        String title = "The Abyss";
        String year = "1989";
        new Library(new StubMovieInfo(title, Integer.parseInt(year)), emailServer).donate("");
        verify(emailServer).send("New Movie", "All Members", new String[]{title, year});
    }


    private class StubMovieInfo implements MovieInfo {
        private String title;
        private int year;

        public StubMovieInfo(String title, int year) {
            this.title = title;
            this.year = year;
        }

        @Override
        public Map<String, String> fetch(String imdbId) {
            Map<String, String> info = new HashMap<>();
            info.put("title", title);
            info.put("year", Integer.toString(year));
            return info;
        }
    }


}
