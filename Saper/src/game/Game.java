package game;

import javax.swing.*;

public class Game {

    static int Game_Board_Width = 10;
    static int Game_Board_Height = 10;
    static int bombs = 10;
    static MainFrameSaper saper;

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        playEasyLevel();
    }

    static void startGame() {
        if (saper != null) saper.dispose();
        saper = new MainFrameSaper();
        MainPanel.boardLabelPanel.fillBoard();
        MainPanel.boardButtonsPanel.fillBoard();
        BoardLabelPanel.insertBombs(bombs);
    }

    public static void endGame() {
        ScoreTimePanel.timer.stop();
        BoardButtonsPanel.showAllUnflaggedBombs();
        BoardButtonsPanel.blockAllFields();
    }

    public static void playEasyLevel() {
        setGameBoardWidth(20);
        setGameBoardHeight(20);
        setBombs(10);
        startGame();
    }

    public static void playIntermediateLevel() {
        setGameBoardWidth(16);
        setGameBoardHeight(16);
        setBombs(40);
        startGame();
    }

    public static void playExpertLevel() {
        setGameBoardWidth(30);
        setGameBoardHeight(16);
        setBombs(100);

        //new MainFrameSaper();
        startGame();
    }

    private static void setGameBoardWidth(int width) {
        Game_Board_Width = width;
    }

    private static void setGameBoardHeight(int height) {
        Game_Board_Height = height;
    }

    private static void setBombs(int bombs) {
        Game.bombs = bombs;
    }

    static public int getGameWidth() {
        return Game_Board_Width;
    }

    static public int getGameHeight() {
        return Game_Board_Height;
    }

    static public int getBombs() {
        return bombs;
    }

}
