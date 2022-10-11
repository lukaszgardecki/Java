package com.example.Testy_Cwiczenie4_TennisGame;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
    }

    public String getScore() {
        return Arbiter.determineResult(player1, player2).getScoreAsText();
    }
}

abstract class Result {
    Player player1;
    Player player2;

    public Result(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    abstract String getScoreAsText();
}

class DrawResult extends Result {

    public DrawResult(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    String getScoreAsText() {
        return player1.getDrawScoreAsText();
    }

}

class AdvantageResult extends Result {

    public AdvantageResult(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    String getScoreAsText() {
        return player1.getScore() > player2.getScore() ? "AdvantageResult player1" : "AdvantageResult player2";
    }
}

class WinResult extends Result {

    public WinResult(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    String getScoreAsText() {
        return player1.getScore() > player2.getScore() ? "Win for player1" : "Win for player2";
    }
}

class OngoingResult extends Result {

    public OngoingResult(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    String getScoreAsText() {
        return player1.getOngoingScoreAsText() + "-" + player2.getOngoingScoreAsText();
    }

}

class Arbiter {
    public static Result determineResult(Player player1, Player player2) {

        if (player1.isTiedWith(player2)) {
            return new DrawResult(player1, player2);
        } else if (eitherPlayerHasAdvantage(player1, player2) &&
                    someoneIsAheadByOnePoint(player1, player2)) {
            return new AdvantageResult(player1, player2);
        } else if (eitherPlayerHasAdvantage(player1, player2)) {
            return new WinResult(player1, player2);
        } else {
            return new OngoingResult(player1, player2);
        }
    }

    private static boolean someoneIsAheadByOnePoint(Player player1, Player player2) {
        return Math.abs(player1.getScore() - player2.getScore()) == 1;
    }

    private static boolean eitherPlayerHasAdvantage(Player player1, Player player2) {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }
}
