package interfaces;

public class Fish implements Prey, Predator{

    @Override
    public void hunt() {
        System.out.println("Ryba poluje na ma�e ryby");
    }

    @Override
    public void flee() {
        System.out.println("Ryba ucieka przed wi�ksz� ryb�");
    }
}
