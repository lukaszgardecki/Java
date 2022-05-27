package pl.am.podstawy.lekcja10;

public class FunkcjaKwadratowa {

    public static double f(double x) {
        return 2*x*x-9*x+4;
    }


    public static void main(String[] args) {
        f(-10);
        double wynik_10 = f(-10);
        double wynik_2 = f(-2);

        System.out.println("f(-10) = " + f(-10));
        System.out.println("f(-2) = " + f(-2));
        System.out.println("f(3) = " + f(3));
        System.out.println("f(5) = " + f(5));
        System.out.println("f(7) = " + f(7));
    }
}
