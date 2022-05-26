package pl.am.podstawy.lekcja8;

import java.util.Scanner;

public class ListaObecnosci {
    public static void main(String[] args) {

        String nazwiska[] = {
                "Kowal",
                "Nowak",
                "Zielinski",
                "Lewandowski",
                "Mazur",
                "Zajac",
                "Dudek"
        };

        int ocenyzmatematyki[] = {5, 3, 4, 2, 5, 5, 3};


        for (int i = 0; i < nazwiska.length; i++) {
            System.out.println(i + 1 + " " + nazwiska[i] + ", ocena: " + ocenyzmatematyki[i]);
        }

        //Liczenie średniej klasowej:
        float suma = 0;
        float srednia;

        for (int i = 0; i < ocenyzmatematyki.length; i++) {
            suma += ocenyzmatematyki[i];
        }
        srednia = suma / ocenyzmatematyki.length;
        System.out.println("Srednia klasowa ocen z matematyki to: " + srednia + ".");
    }
}
