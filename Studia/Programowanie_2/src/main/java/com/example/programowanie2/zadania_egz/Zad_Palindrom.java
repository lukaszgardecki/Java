package com.example.programowanie2.zadania_egz;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Zad_Palindrom {
    public static void main(String[] args) {
        String[] slowa = { "kajak", "ABBA", "Ala", "Ola"};
        int palindromy = funkcja(slowa, "palindromy.txt");
        System.out.println("Liczba palindromów: " + palindromy);
    }

    private static int funkcja(String[] slowa, String nazwaPlikuDocelowego) {
        int palindromy = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPlikuDocelowego))) {
            for (String slowo : slowa) {
                boolean palindrom = true;

                for (int i = 0; i < slowo.length() / 2; i++) {
                    char c1 = slowo.charAt(i);
                    char c2 = slowo.charAt(slowo.length() - 1 - i);
                    if (c1 != c2) {
                        palindrom = false;
                        break;
                    }
                }

                if (palindrom) {
                    writer.write(slowo + ": PALINDROM\n");
                    palindromy++;
                } else {
                    writer.write(slowo + ": NIE PALINDROM\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }


        return palindromy;
    }
}
