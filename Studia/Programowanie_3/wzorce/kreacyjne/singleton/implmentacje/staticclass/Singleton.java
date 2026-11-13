package wzorce.kreacyjne.singleton.implmentacje.staticclass;

public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    private static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
