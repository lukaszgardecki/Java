package pl.am.podstawy.lekcja5;

import java.util.Scanner;

public class PrymitywnyKalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwsza liczbe calkowita");
        int a = scanner.nextInt();

        System.out.println("Podaj druga liczbe calkowita");
        int b = scanner.nextInt();

        int suma = a + b;
        int roznica = a - b;
        int iloczyn = a * b;


        System.out.println("Suma " + a + " + " + b + " = " + suma);
        System.out.println("Roznica " + a + " - " + b + " = " + roznica);
        System.out.println("Iloczyn " + a + " * " + b + " = " + iloczyn);

        if (b == 0) {
            System.out.println("Pamiętaj cholero, nie dziel przez zero!");
        } else {
            int iloraz = a / b;
            int reszta = a % b;

            System.out.println( "Iloraz " + a + " / " + b + " = " + iloraz + " reszty " + reszta);
        }




    }
}
