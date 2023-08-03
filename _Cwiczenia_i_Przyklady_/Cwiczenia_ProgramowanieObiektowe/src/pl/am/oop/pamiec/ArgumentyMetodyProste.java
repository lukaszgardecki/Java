package pl.am.oop.pamiec;

public class ArgumentyMetodyProste {

    public static double zwieksz(double zmienna) {

        return zmienna = 1.15*zmienna;

    }

    public static void main(String[] args) {
        double x = 2000;

        x = zwieksz(x);
        System.out.println("x = " + x);
    }
}
