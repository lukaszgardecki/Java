package Tablice;

import java.util.SplittableRandom;

public class Ko�o {

    private double promien;

    Ko�o(double r) {
        this.promien = r;
    }

    public double obliczObwod() {
        double obwod = 2*Math.PI * promien;
        return obwod;
    }

    public double obliczPole() {
        double pole = Math.PI * promien * promien;
        return pole;
    }




    public static void main(String[] args) {
        Ko�o k1 = new Ko�o(5);
        System.out.println("Obw�d ko�a wynosi " + k1.obliczObwod());
        System.out.println("Pole ko�a wynosi " + k1.obliczPole());
    }
}
