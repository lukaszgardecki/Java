package com.example.Testy_Cwiczenie5.TDD_5;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private MovieInfo movieInfo;
    private EmailServer emailServer;
    private Map<String, Movie> catalogue = new HashMap<>();

    public Library(MovieInfo movieInfo, EmailServer emailServer) {
        this.movieInfo = movieInfo;
        this.emailServer = emailServer;
    }

    public void donate(String imdbId) {
        Map<String, String> info = movieInfo.fetch(imdbId);
        catalogue.put(imdbId, new Movie(info.get("title"), Integer.parseInt(info.get("year"))));
        emailServer.send("New Movie", "All Members", new String[]{info.get("title"), info.get("year")});

    }

    public Movie findMovie(String imdbId) {
        return catalogue.get(imdbId);
    }
}
