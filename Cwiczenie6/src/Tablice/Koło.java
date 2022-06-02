package Tablice;

import java.util.SplittableRandom;

public class Ko這 {

    private double promien;

    Ko這(double r) {
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
        Ko這 k1 = new Ko這(5);
        System.out.println("Obw鏚 ko豉 wynosi " + k1.obliczObwod());
        System.out.println("Pole ko豉 wynosi " + k1.obliczPole());
    }
}
