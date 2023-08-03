package Dziedziczenie;

public class Kolo extends Figura {

    private double promien;

    public Kolo() {
        this(1.0);
    }

    public Kolo(double r) {
        this(r, "Fioletowy", true);
    }

    public Kolo(double r, String k, boolean w) {
        super(k, w);
        promien = r;
    }

    public double obliczObwod() {
        return 2*Math.PI * promien;
    }

    public double obliczPole() {
        return Math.PI * promien * promien;
    }

    public String toString() {
        return "Promieñ: " + promien + ", obwód: " + obliczObwod() + ", pole: " + obliczPole() + ", " + super.toString();
    }

    public static void main(String[] args) {
        Kolo kolko = new Kolo(4,"Zielony", true);
        System.out.println(kolko);
    }
}
