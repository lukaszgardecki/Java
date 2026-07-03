package com.example.programowanie2.zadania_egz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Dany jest plik (nietekstowy), w którym zapisano (w postaci wewnętrznej) kolejne trójki danych tworzące
 * informacje o lekach:
 *      String lek;         // nazwa leku
 *      int cena;
 *      double rabat;       // w procentach
 *
 * Napisać funkcję zmniejszającą (bezpośrednio w pliku, bez wczytywania całego pliku do pamięci) cenę leków
 * z rabatem (rabat > 0) o procent równy wartości rabatu i zwracającą jako wartość nazwę leku o najniższej cenie
 * (liczonej z rabatem). Jeśli jest takich więcej, to należy zwrócić ich listę w postaci łańcucha:
 * "lek1, lek2, ...".
 * Nazwa pliku jest przekazana jako pierwszy parametr funkcji.
 * Wszystkie leki z końcowymi cenami przepisać do pliku tekstowego o nazwie przekazanej drugim parametrem
 * (w jednym wierszu: "lek: cena").
 */

public class Zad_pliki_2 {

    String funkcja(String nazwaPlikuSrc, String nazwaPlikuDst) {
        List<String> najtanszeLeki = new ArrayList<>();
        int cenaMin = Integer.MAX_VALUE;

        try (
                var raf = new RandomAccessFile(nazwaPlikuSrc, "rw");
                var bw = new BufferedWriter(new FileWriter(nazwaPlikuDst))
        ) {
            while (raf.getFilePointer() < raf.length()) {
                String nazwaLeku = raf.readUTF();
                long cenaPointer = raf.getFilePointer();
                int cena = raf.readInt();
                double rabat = raf.readDouble();        // założono zapis 34.0 (%)
                long endPointer = raf.getFilePointer();

                if (rabat > 0) {
                    raf.seek(cenaPointer);
                    cena = (int) (cena * (100.0 - rabat) / 100.0);
                    raf.writeInt(cena);
                }

                if (cena <= cenaMin) {
                    if (cena < cenaMin) {
                        najtanszeLeki.clear();
                        cenaMin = cena;
                    }
                    najtanszeLeki.add(nazwaLeku);
                }


                bw.write("%s: %s\n".formatted(nazwaLeku, cena));
                raf.seek(endPointer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        return String.join(", ", najtanszeLeki);
    }
}
