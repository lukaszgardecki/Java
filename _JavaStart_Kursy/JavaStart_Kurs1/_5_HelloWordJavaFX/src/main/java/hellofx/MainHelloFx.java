package hellofx;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainHelloFx extends Application {

    public MainHelloFx() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("main");
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello FX!");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
    }
}
