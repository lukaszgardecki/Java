package game;

public class Game {

    private int Game_Board_Width;
    private int Game_Board_Height;
    private int bombs;
    private String level;

    public Game(String level) {
        this.level = level;

        switch (level) {
            case "easy" -> {
                setGame_Board_Width(9);
                setGame_Board_Height(9);
                setBombs(10);
            }
            case "intermediate" -> {
                setGame_Board_Width(16);
                setGame_Board_Height(16);
                setBombs(40);
            }
            case "expert" -> {
                setGame_Board_Width(30);
                setGame_Board_Height(16);
                setBombs(100);
            }
        }
    }

    public static void endGame() {
        ScoreTimePanel.timer.stop();
        BoardButtonsPanel.showAllUnflaggedBombs();
        BoardButtonsPanel.blockAllFields();
    }

    public static void winGame() {
        System.out.println("Gra wygrana!");
        ScoreTimePanel.timer.stop();
        BoardButtonsPanel.blockAllFields();
    }

    public int getGameWidth() {
        return Game_Board_Width;
    }

    public int getGameHeight() {
        return Game_Board_Height;
    }

    public int getBombs() {
        return bombs;
    }

    public String getLevel() {
        return level;
    }

    private void setGame_Board_Width(int game_Board_Width) {
        Game_Board_Width = game_Board_Width;
    }

    private void setGame_Board_Height(int game_Board_Height) {
        Game_Board_Height = game_Board_Height;
    }

    private void setBombs(int bombs) {
        this.bombs = bombs;
    }
}
