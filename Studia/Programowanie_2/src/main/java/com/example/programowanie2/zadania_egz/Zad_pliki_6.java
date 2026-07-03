package com.example.programowanie2.zadania_egz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Napisać funkcję, która analizuje plik o dostępie bezpośrednim, o nazwie podanej jako parametr.
 *
 * W pliku na pierwszym miejscu znajduje się liczba mówiąca o tym, ile jest elementów, a następnie
 * właściwe elementy (double), które należy pobrać.
 *
 * Funkcja ma pobierać liczby i wykonywać naprzemiennie operacje dodawania i odejmowania,
 * a następnie dopisać na koniec pliku wynik końcowy.
 *
 * Przykład:
 *
 * Postać pliku: 5.0 3.14 2.17 4.5 3.1 2.0
 * Operacje 3.14+2.17-4.5+3.1-2.0
 * Wynik: 1.91
 */
public class Zad_pliki_6 {
    void funkcja(String nazwaPliku) {
        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            int ileLiczb = (int) raf.readDouble();
            double wynik = raf.readDouble();

            for (int i = 0; i < ileLiczb-1; i++) {
                double liczba = raf.readDouble();
                if (i % 2 == 0) {
                    wynik += liczba;
                } else {
                    wynik -= liczba;
                }
            }

            raf.writeDouble(wynik);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
