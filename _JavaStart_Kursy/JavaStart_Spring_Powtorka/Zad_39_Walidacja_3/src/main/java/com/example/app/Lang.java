package com.example.app;

public enum Lang {
    PL(new String[] {"bs1", "bs2", "bs3", "bs4"}),
    EN(new String[]{"bw1"});

    private final String[] badWords;

    Lang(String[] badWords) {
        this.badWords = badWords;
    }

    public String[] getBadWords() {
        return badWords;
    }
}
