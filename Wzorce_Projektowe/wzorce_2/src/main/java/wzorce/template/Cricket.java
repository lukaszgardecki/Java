package wzorce.template;

public class Cricket extends Game {


    @Override
    void initialize() {
        System.out.println("Cricket game initialized! Start Playing!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game is finished.");
    }
}
