package game;

public class Main {

    static Game game;
    static MainFrameSaper frame;

    public static void main(String[] args) {
        setEasyLevel();
        frame = new MainFrameSaper();
    }

    public static void setEasyLevel() {
        game = new Game("easy");
    }

    public static void setIntermediateLevel() {
        game = new Game("intermediate");
    }

    public static void setExpertLevel() {
        game = new Game("expert");
    }

}
