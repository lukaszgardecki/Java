package game;

public class Main {

    static Game game;
    static MainFrameSaper frame;

    public static void main(String[] args) {
        game = new Game(Level.EASY);
        frame = new MainFrameSaper();
    }

    public static void setEasyLevel() {
        game = new Game(Level.EASY);
    }

    public static void setIntermediateLevel() {
        game = new Game(Level.INTERMEDIATE);
    }

    public static void setExpertLevel() {
        game = new Game(Level.EXPERT);
    }

}
