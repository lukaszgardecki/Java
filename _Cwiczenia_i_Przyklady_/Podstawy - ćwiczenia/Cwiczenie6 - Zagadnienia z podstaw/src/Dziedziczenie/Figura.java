package Dziedziczenie;

//w klasach abstrakcyjnych nie mo¿na definiowaæ obiektów

public abstract class Figura {

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
        return "Kolor: " + kolor + ", wype³nienie: " + wypelnienie;
    }

    public abstract double obliczPole();
    public abstract double obliczObwod();
}
