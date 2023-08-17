package wzorce.abstractfactory;

import wzorce.abstractfactory.factory.WinUIFactory;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new WinUIFactory());
        application.paint();
    }
}
