package pl.am.podstawy.lekcja4;

import java.util.Scanner;

public class Decyzja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ile masz lat?");
        int wiek = scanner.nextInt();
        boolean nieletni = wiek < 18;

        if (nieletni) {
            System.out.println("Jestes nieletni");
        } else if (wiek <= 200) {
            System.out.println("Jestes dorosly");
        } else {
            System.out.println("Nie wierze Ci");
        }
    }
}
