package game;

public enum Level {
    EASY(9, 9, 10),
    INTERMEDIATE(16, 16, 40),
    EXPERT(30, 16, 100);

    private final int boardWidth;
    private final int boardHeight;
    private final int bombs;


    Level(int boardWidth, int boardHeight, int bombs) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.bombs = bombs;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBombs() {
        return bombs;
    }
}
