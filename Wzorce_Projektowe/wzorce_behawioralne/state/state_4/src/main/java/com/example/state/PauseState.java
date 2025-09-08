package com.example.state;

public class PauseState implements MediaPlayerState {

    @Override
    public void pressButton(MediaPlayer mediaPlayer) {
        mediaPlayer.play();
        mediaPlayer.setState(new PlayingState());
    }
}
