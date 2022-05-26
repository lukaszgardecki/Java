package pl.am.podstawy.lekcja5;

import java.util.Scanner;

public class PrzelicznikCali {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - - PRZELICZNIK CALI NA CENTYMETRY - - - -");
        System.out.println("Podaj ilosc cali: ");

        // Ile centymetrów ma jeden cal? FINAL zamienia zmienną na stałą
        final double jedencal = 2.54;

        double cale = scanner.nextDouble();
        double centymetry = cale * jedencal;
        System.out.println("Wynik to: " + centymetry + " cm.");



    }
}
