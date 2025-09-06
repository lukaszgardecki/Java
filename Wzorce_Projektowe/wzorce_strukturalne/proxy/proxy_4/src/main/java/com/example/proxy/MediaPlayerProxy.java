package com.example.proxy;

public class MediaPlayerProxy implements MediaPlayer {
    private MovieMediaPlayer movieMediaPlayer;

    @Override
    public void playMedia() {
        if (movieMediaPlayer == null) {
            this.movieMediaPlayer = new MovieMediaPlayer();
        }
        movieMediaPlayer.playMedia();
    }
}
