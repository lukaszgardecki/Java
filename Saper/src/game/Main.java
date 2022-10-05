package game;

public class Main {

    static Game game;
    static MainFrameSaper frame;

    public static void main(String[] args) {
        playEasyLevel();
        frame = new MainFrameSaper();
    }

    public static void playEasyLevel() {
        game = new Game("easy");
    }

    public static void playIntermediateLevel() {
        game = new Game("intermediate");
    }

    public static void playExpertLevel() {
        game = new Game("expert");
    }

}
