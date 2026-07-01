package com.example.programowanie2.zadania_egz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Do pliku o dostępie bezpośrednim wpisano informacje dotyczące filmów.
 * Dane te wpisano w następującej kolejności:
 *
 *      imię i nazwisko reżysera - łańcuch znaków
 *      tytuł filmu - łańcuch znaków
 *      rok produkcji - liczba całkowita
 *      koszt filmu - liczba rzeczywista
 *
 * Napisać funkcję, której parametrem jest nazwa pliku.
 * Funkcja powinna korygować W TYM PLIKU nazwiska i imiona (zamienić pierwszą literę, jeżeli jest mała, na dużą,
 * resztę liter - na małe, jeśli są tam litery duże - założyć, że nie ma polskich liter).
 * Jeżeli film został wyprodukowany przed rokiem 2000, funkcja powinna zwiększyć koszt filmu o 25%.
 * Funkcja powinna zwrócić rok produkcji filmu o najwiekszym koszcie po zmianie.
 */

public class Zad_pliki_1 {

    int funkcja(String nazwaPliku) {
        int rokMaxKoszt = -1;
        double maxCost = -1;

        try (var raf = new RandomAccessFile(nazwaPliku, "rw")) {

            while(raf.getFilePointer() < raf.length()) {
                long namePointer = raf.getFilePointer();
                String name = raf.readUTF();
                String title = raf.readUTF();
                int year = raf.readInt();
                long costPointer = raf.getFilePointer();
                double cost = raf.readDouble();
                long endPointer = raf.getFilePointer();

                String updatedName = Arrays.stream(name.split("\\s"))
                        .map(old -> old.substring(0, 1).toUpperCase() + old.substring(1).toLowerCase())
                        .collect(Collectors.joining(" "));

                raf.seek(namePointer);
                raf.writeUTF(updatedName);

                if (year < 2000) {
                    cost = cost * 1.25;
                    raf.seek(costPointer);
                    raf.writeDouble(cost);
                }

                if (cost > maxCost) {
                    maxCost = cost;
                    rokMaxKoszt = year;
                }
                raf.seek(endPointer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return rokMaxKoszt;
    }
}
