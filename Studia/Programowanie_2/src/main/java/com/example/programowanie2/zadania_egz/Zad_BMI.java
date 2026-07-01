package com.example.programowanie2.zadania_egz;

import java.util.Scanner;

public class Zad_BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] tablicaBmi = new double[100];
        int licznik = 0;

        boolean czyBylaKobieta = false;
        boolean czyBylMezczyzna = false;

        double maxBmiMezczyzni = -1.0;
        double sumaBmi = 0.0;

        while (!(czyBylaKobieta && czyBylMezczyzna) && licznik < 100) {
            System.out.println("Podaj wagę (double):");
            double waga = sc.nextDouble();
            System.out.println("Podaj wzrost w cm (int):");
            int wzrostCm = sc.nextInt();
            System.out.println("Podaj płeć (0 - kobieta, 1 - mężczyzna):");
            int plec = sc.nextInt();

            double wzrostM = wzrostCm / 100.0;
            double bmi = 0.0;

            if (plec == 0) { // Kobieta: wzrost +10%
                double wzrostKobiety = wzrostM * 1.10;
                bmi = waga / (wzrostKobiety * wzrostKobiety);
                czyBylaKobieta = true;
            } else { // Mężczyzna: waga -15%
                double wagaMezczyzny = waga * 0.85;
                bmi = wagaMezczyzny / (wzrostM * wzrostM);
                czyBylMezczyzna = true;

                if (bmi > maxBmiMezczyzni) {
                    maxBmiMezczyzni = bmi;
                }
            }

            tablicaBmi[licznik] = bmi;
            sumaBmi += bmi;
            licznik++;

            // Wypisanie kategorii
            System.out.printf("Płeć: %s, BMI: %.2f, Kategoria: ",
                    (plec == 0 ? "kobieta" : "mężczyzna"), bmi);
            if (bmi < 18.5) System.out.println("niedowaga");
            else if (bmi < 25.0) System.out.println("norma");
            else if (bmi < 30.0) System.out.println("nadwaga");
            else System.out.println("otyłość");
        }

        // Wyniki końcowe
        System.out.println("\n--- WYNIKI ---");
        System.out.print("Wszystkie wartości BMI: ");
        for (int i = 0; i < licznik; i++) {
            System.out.printf("%.2f ", tablicaBmi[i]);
        }
        System.out.printf("%nNajwiększe BMI mężczyzn: %.2f", maxBmiMezczyzni);
        System.out.printf("%nŚrednie BMI wszystkich: %.2f", (sumaBmi / licznik));
    }
}
