package com.example.programowanie2.zadania_egz;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Napisać klasę Egzamin reprezentującą informacje o ocenach z egzaminu z programowania.
 * Klasa powinna zawierać pole prywatne:
 *      float[][] oceny - tablica z listą ocen studentów (pierwszy "wymiar" - numer studenta, drugi "wymiar" - nr zadania)
 *
 * Konstruktor z dwoma parametrami (int liczbaStudentow, int liczbaZadan) powinien tworzyć i zainicjować odpowiednie
 * elementy tablicy na wartość 0.
 *
 * Zdefiniować metody publiczne:
 *      float obliczSrednia(int student) - oblicza i zwraca średnią ocen (pełną ocenę - bez "połówek") dla podanego
 *      studenta (gdy większość zadań ma ocenę większą niż 2, w przeciwnym razie średnia wynosi 2)
 *
 *      boolean zaliczonyEgzamin(int student) - zwraca true, jeśli średnia ocen jest większa lub równa 3.0,
 *      w przeciwnym wypadku false.
 *
 *      void wpiszOcene(int student, int zadanie, float ocena) - dodaje nową ocenę
 *
 *      void pisz() - wyświetla na konsoli oceny studentów (w jednym wierszu, numer studenta, lista ocen, średnia ocen)
 */
public class Zad_klasa_2 {
    public static void main(String[] args) {
        Egzamin egzamin = new Egzamin(5, 7);
        egzamin.wpiszOcene(0, 0, 3f);
        egzamin.wpiszOcene(0, 1, 5f);
        egzamin.wpiszOcene(0, 2, 2f);
        egzamin.wpiszOcene(0, 3, 2f);
        egzamin.wpiszOcene(0, 4, 3.5f);
        egzamin.wpiszOcene(0, 5, 3f);
        egzamin.wpiszOcene(0, 6, 4f);

        boolean zaliczony = egzamin.zaliczonyEgzamin(0);
        float srednia = egzamin.obliczSrednia(0);
        System.out.printf("Student %d zdobył średnią %.0f (%s)%n", 0, srednia, zaliczony ? "zaliczone" : "niezaliczone");

        System.out.println("-------------");
        egzamin.pisz();
    }
}

class Egzamin {
    private float[][] oceny;    // [nr studenta][nr zadania]

    Egzamin(int liczbaStudentow, int liczbaZadan) {
        oceny = new float[liczbaStudentow][liczbaZadan];

        // PO CO ręcznie inicjalizować zera? float fomyślnie chyba będzie 0 w tablicy
        for (float[] row : oceny) {
            Arrays.fill(row, 0f);
        }
    }

    float obliczSrednia(int student) {
        float[] ocenyStudenta = oceny[student];
        int zadaniaPowyzej2 = 0;

        for (float ocena : ocenyStudenta) {
            if (ocena > 2f) zadaniaPowyzej2++;
        }

        if (zadaniaPowyzej2 > ocenyStudenta.length / 2) {
            int iloscOcen = ocenyStudenta.length;
            float suma = 0f;
            for (float ocena : ocenyStudenta) {
                suma += ocena;
            }
            return Math.round(suma / iloscOcen);
        }
        return 2f;
    }

    boolean zaliczonyEgzamin(int student) {
        return obliczSrednia(student) >= 3.0f;
    }

    void wpiszOcene(int student, int zadanie, float ocena) {
        oceny[student][zadanie] = ocena;
    }

    void pisz() {
        for (int nrStud = 0; nrStud < oceny.length; nrStud++) {
            float srednia = obliczSrednia(nrStud);
            float[] ocenyStudenta = oceny[nrStud];

            String ocenyStr = IntStream.range(0, ocenyStudenta.length)
                    .mapToObj(i -> String.valueOf(ocenyStudenta[i]))
                    .collect(Collectors.joining(", "));

            System.out.printf("%d, %s, %.0f%n", nrStud, ocenyStr, srednia);
        }
    }
}