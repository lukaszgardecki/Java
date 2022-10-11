package com.example.Testy_Cwiczenie4_TennisGame;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    boolean isTiedWith(Player otherPlayer) {
        return score == otherPlayer.score;
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    String getDrawScoreAsText() {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    boolean isAheadOf(Player otherPlayer) {
        return score > otherPlayer.score;
    }

    String getOngoingScoreAsText() {
        return switch (score) {
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "Love";
        };
    }
}
