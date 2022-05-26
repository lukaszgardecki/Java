package pl.am.podstawy.lekcja3;

import java.util.Scanner;

public class KtoTy {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Jak masz na imię?");
        String imie;
        imie = s.nextLine();

        System.out.println("Ile masz lat?");
        String wiek;
        wiek = s.nextLine();

        System.out.println("Czesc " + imie + ". Wiem, ze masz " + wiek + " lat.");
    }
}
