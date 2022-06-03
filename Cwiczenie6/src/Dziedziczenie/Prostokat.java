package Dziedziczenie;

import RownanieKwadratowe.RownanieKwadratowe;

public class Prostokat extends Figura {
    private  double bokA;
    private double bokB;


    //Konstruktor domy�lny:
    public Prostokat() {
        this(1.0, 1.0);
    }
    //Konstruktor z dwoma parametrami:
    public Prostokat(double a, double b) {
        this.bokA = a;
        this.bokB = b;
    }

    //metoda obliczaj�ca pole:
    public double obliczPole() {
        return bokA * bokB;
    }

    //metoda obliczaj�ca obw�d:
    public double obliczObwod() {
        return 2 * (bokA + bokB);
    }


    public String toString() {
        return "Nazwa: " + getClass().getName() + ", Bok a: " + bokA + ", Bok b: " + bokB + ", obw�d: " + obliczObwod() + ", pole: " + obliczPole();
    }

    public static void main(String[] args) {
        Prostokat pr = new Prostokat(2, 4);
        System.out.println(pr);
    }


}
