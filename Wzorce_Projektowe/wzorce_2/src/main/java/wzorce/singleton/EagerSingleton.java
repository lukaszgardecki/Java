package wzorce.singleton;

public class EagerSingleton {
    private static final EagerSingleton instace = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instace;
    }
}
