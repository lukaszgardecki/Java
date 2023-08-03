package game;

public class Game {
    private int boardWidth;
    private int boardHeight;
    private int bombs;
    private Level level;
    static boolean isFailure = false;

    public Game(Level level) {
        this.level = level;
        this.boardWidth = level.getBoardWidth();
        this.boardHeight = level.getBoardHeight();
        this.bombs = level.getBombs();
    }

    public static void endGame() {
        isFailure = true;
        ScoreTimePanel.timer.stop();
        BoardButtonsPanel.showAllUnflaggedBombs();
        BoardButtonsPanel.blockAllFields();
    }

    public static void winGame() {
        System.out.println("Gra wygrana!");
        ScoreTimePanel.timer.stop();
        BoardButtonsPanel.blockAllFields();
    }

    public static void playEasy() {
        Main.setEasyLevel();
        prepareGame();
    }

    public static void playIntermediate() {
        Main.setIntermediateLevel();
        prepareGame();
    }

    public static void playExpert() {
        Main.setExpertLevel();
        prepareGame();
    }

    private static void prepareGame() {
        MainFrameSaper.container.changeSize();
        MainContainer.changeSizeOfElements();
        MainPanel.refresh();
        Main.frame.changeSize();
    }

    public int getGameWidth() {
        return boardWidth;
    }

    public int getGameHeight() {
        return boardHeight;
    }

    public int getBombs() {
        return bombs;
    }

    public Level getLevel() {
        return level;
    }

    private void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    private void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    private void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
