package Dziedziczenie;

public class Kolo extends Figura {

    private double promien;

    public Kolo() {
        this(1.0);
    }

    public Kolo(double r) {
        promien = r;
    }

    public double obliczObwod() {
        return 2*Math.PI * promien;
    }

    public double obliczPole() {
        return Math.PI * promien * promien;
    }

    public String toString() {
        return "Promieñ: " + promien + ", obwód: " + obliczObwod() + ", pole: " + obliczPole() + ", kolor: " + super.kolor;
    }

    public static void main(String[] args) {
        Kolo kolko = new Kolo();
        System.out.println(kolko);
    }
}
