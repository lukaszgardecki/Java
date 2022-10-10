package com.example.Testy_Cwiczenie4_TennisGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TennisTest {
    private final TennisGame1 game = new TennisGame1("player1","player2");


    @ParameterizedTest(name = "playerOne: {0} playerTwo: {1} - {2}")
    @CsvSource({
            "0, 0, Love-All",
            "1, 1, Fifteen-All",
            "2, 2, Thirty-All",
            "3, 3, Deuce",
            "4, 4, Deuce",
            "5, 5, Deuce",

            "1, 0, Fifteen-Love",
            "0, 1, Love-Fifteen",

            "2, 0, Thirty-Love",
            "0, 2, Love-Thirty",

            "3, 0, Forty-Love",
            "0, 3, Love-Forty",

            "4, 0, Win for player1",
            "0, 4, Win for player2",

            "2, 1, Thirty-Fifteen",
            "1, 2, Fifteen-Thirty",

            "3, 1, Forty-Fifteen",
            "1, 3, Fifteen-Forty",

            "4, 1, Win for player1",
            "1, 4, Win for player2",

            "3, 2, Forty-Thirty",
            "2, 3, Thirty-Forty",

            "4, 2, Win for player1",
            "2, 4, Win for player2",

            "4, 3, Advantage player1",
            "3, 4, Advantage player2",

            "5, 4, Advantage player1",
            "4, 5, Advantage player2",

            "6, 4, Win for player1",
            "4, 6, Win for player2",

            "15, 14, Advantage player1",
            "14, 15, Advantage player2",

            "16, 14, Win for player1",
            "14, 16, Win for player2"
    })
    void score(int player1Score, int player2Score, String ExpectedScore) {
        setPlayerScore("player1", player1Score);
        setPlayerScore("player2", player2Score);

        String score = game.getScore();

        assertThat(score).isEqualTo(ExpectedScore);
    }



    private void setPlayerScore(String playerName, int pointsWon) {
        for (int i = 0; i < pointsWon; i++) {
            game.wonPoint(playerName);
        }
    }

}
