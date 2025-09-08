package com.example.state;

public class MediaPlayer {
    private MediaPlayerState state;

    public MediaPlayer() {
        this.state = new PauseState();
    }

    public void pressButton() {
        state.pressButton(this);
    }

    public void play() {
        System.out.println("Playing");
        System.out.println("Displaying pause icon");
    }

    public void pause() {
        System.out.println("Paused");
        System.out.println("Displaying play icon");
    }

    public void setState(MediaPlayerState state) {
        this.state = state;
    }
}
