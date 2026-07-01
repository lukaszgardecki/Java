package com.example.programowanie2.zadania_egz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Dany jest plik danych o strukturze:
 *      imię (łańcuch znaków)
 *      nazwisko (łańcuch znaków)
 *      kredyt (liczba rzeczywista)
 *      pensja (liczba rzeczywista)
 *      wiek (liczba całkowita)
 *
 * Napisać funkcję wpisującą W TYM PLIKU proponowaną kwotę kredytu.
 * Kwota jest wyliczana według wzoru: kredyt = (pensja / 7) * (65 - wiek)
 *
 * Parametrem funkcji jest nazwa pliku.
 * Funkcja powinna zwrócić łańcuch znaków, zawierający imię i nazwisko osoby z największym proponowanym kredytem
 * (dowolnej osoby, gdy jest ich więcej).
 */
public class Zad_pliki_4 {
    String funkcja(String nazwaPliku) {
        String osobaMaxKredyt = "Imie Nazwisko";
        double maxKredyt = -Double.MAX_VALUE;

        try (var raf = new RandomAccessFile(nazwaPliku, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                String imie = raf.readUTF();
                String nazwisko = raf.readUTF();
                long kredytPointer = raf.getFilePointer();
                double kredyt = raf.readDouble();
                double pensja = raf.readDouble();
                int wiek = raf.readInt();
                long endPointer = raf.getFilePointer();

                kredyt = (pensja / 7) * (65 - wiek);

                if (kredyt > maxKredyt) {
                    maxKredyt = kredyt;
                    osobaMaxKredyt = "%s %s".formatted(imie, nazwisko);
                }

                raf.seek(kredytPointer);
                raf.writeDouble(kredyt);
                raf.seek(endPointer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        return osobaMaxKredyt;
    }
}
