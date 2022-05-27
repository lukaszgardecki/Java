package pl.am.podstawy.lekcja10;

import java.util.Scanner;


public class MiejscaZerowe {

    public static double obliczDelte(double a, double b, double c) {
        return b*b-4*a*c;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wspolczynniki funkcji kwadratowej f(x) = ax^2 + bx + c");

        System.out.println("Podaj a: ");
        double a = scanner.nextDouble();

        System.out.println("Podaj b: ");
        double b = scanner.nextDouble();

        System.out.println("Podaj c: ");
        double c = scanner.nextDouble();

        double delta = obliczDelte(a, b, c);

        if (delta < 0) {
            System.out.println("Brak miejsc zerowych.");
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            System.out.println("Jest jedno miejsce zerowe: " + x0);
        } else {
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.println("Są dwa miejsca zerowe: " + x1 + " oraz " + x2);
        }
    }
}
