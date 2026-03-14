package com.example.programowanie2.cwiczenia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        System.out.println("Program przelicza odległość w metrach na cale, stopy, jardy i mile lądowe.");

        System.out.print("Podaj odległość w metrach: ");
        double metry = skaner.nextDouble();

        double cale = metry * 39.3700787;
        double stopy = metry * 3.2808399;
        double jardy = metry * 1.0936133;
        double mile = metry * 0.000621371192;

        System.out.println("--- Wyniki przeliczenia ---");
        System.out.printf("Cale: %.4f%n", cale);
        System.out.printf("Stopy: %.4f%n", stopy);
        System.out.printf("Jardy: %.4f%n", jardy);
        System.out.printf("Mile lądowe: %.6f%n", mile);
    }
}
