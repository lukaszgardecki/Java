package pl.am.podstawy.lekcja6;

import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podawaj liczby calkowite. Zero konczy program.");

        int liczba;
        int suma = 0;

        do {
            System.out.print("Podaj liczbe: ");
            liczba = scanner.nextInt();
            suma += liczba;
        } while (liczba != 0);

        System.out.println("suma = " + suma);
    }
}
