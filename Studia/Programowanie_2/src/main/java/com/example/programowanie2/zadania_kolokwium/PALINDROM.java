package com.example.programowanie2.zadania_kolokwium;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Napisać metodę, która sprawdza, czy łańcuchy podane w tablicy łańcuchów, przekazanej parametrem, są
 * palindromami. Należy odwrócić każdy łańcuch „na piechotę” i porównać go z oryginalnym. Kolejne łańcuchy
 * powinny być wpisywane do pliku tekstowego (o nazwie podanej drugim parametrem) z dopiskiem: PALINDROM
 * lub NIE PALINDROM.
 *
 * Metoda powinna zwrócić liczbę palindromów.
 */
public class PALINDROM {
    public static void main(String[] args) {
        new CzyPalindrom().run();
    }
}

class CzyPalindrom {

    void run() {
        String[] napisy = { "kajak", "ABBA", "Ala", "Ola" };
        int palindromy = metoda(napisy, "palindromy.txt");
        System.out.println("Palindromy: " + palindromy);
    }

    int metoda(String[] napisy, String nazwaPliku) {
        int licznik = 0;

        try (var writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            for (int i = 0; i < napisy.length; i++) {
                String napis = napisy[i];
                StringBuilder sb = new StringBuilder();
                for (int j = napis.length() - 1; j >= 0; j--) {
                    sb.append(napis.charAt(j));
                }

                boolean palindrom = napis.equals(sb.toString());
                if (palindrom) licznik++;
                String palindromStr = palindrom ? "PALINDROM" : "NIE PALINDROM";
                writer.write(napis + ": " + palindromStr);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Błąd pliku.");
        }

        return licznik;
    }
}
