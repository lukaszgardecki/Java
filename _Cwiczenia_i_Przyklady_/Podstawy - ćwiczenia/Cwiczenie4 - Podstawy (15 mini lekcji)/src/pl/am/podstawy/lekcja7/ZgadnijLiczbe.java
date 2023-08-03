package pl.am.podstawy.lekcja7;

import java.util.Random;
import java.util.Scanner;

public class ZgadnijLiczbe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int liczbaDoZgadniecia = random.nextInt(100) + 1;

        System.out.println("Wymyslilem liczbe z przedzialu 1-100. Zgadnij co to za liczba!");

        int liczbaOdUzytkownika;
        int iloscProb = 0;
        do {
            System.out.println("Podaj liczbe: ");
            liczbaOdUzytkownika = scanner.nextInt();

            if (liczbaOdUzytkownika < liczbaDoZgadniecia) {
                iloscProb++;
                System.out.println("Podales za mala liczbe.Moja liczba jest wieksza!");
            } else if (liczbaOdUzytkownika > liczbaDoZgadniecia) {
                iloscProb++;
                System.out.println("Podales za duza liczbe. Moja liczba jest mniejsza!");
            } else {
                iloscProb++;
                System.out.println("Brawo! Zgadles! Liczba to " + liczbaDoZgadniecia + ". Zgadles za " + iloscProb + " razem.");
            }
        } while (liczbaOdUzytkownika != liczbaDoZgadniecia);
    }
}
