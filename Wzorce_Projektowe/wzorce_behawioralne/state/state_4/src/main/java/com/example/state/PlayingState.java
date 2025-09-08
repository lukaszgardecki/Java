package com.example.state;

public class PlayingState implements MediaPlayerState {

    @Override
    public void pressButton(MediaPlayer mediaPlayer) {
        mediaPlayer.pause();
        mediaPlayer.setState(new PauseState());
    }
}
