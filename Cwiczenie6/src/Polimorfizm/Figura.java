package Polimorfizm;

public class Figura {

    String kolor;
    boolean wypelnienie;

    public Figura() {
        this("Czarny", false);
    }

    public Figura(String k, boolean w) {
        kolor = k;
        wypelnienie = w;
    }

    public String toString() {
        return "Kolor: " + kolor + ", wype�nienie: " + wypelnienie;
    }

    public static void main(String[] args) {

    }
}
