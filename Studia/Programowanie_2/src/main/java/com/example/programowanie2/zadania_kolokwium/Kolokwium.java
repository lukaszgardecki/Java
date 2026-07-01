package com.example.programowanie2.zadania_kolokwium;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Kolokwium {
    public static void main(String[] args) {
        poprawLataDoEmerytury("plik.bin");
    }

    static String poprawLataDoEmerytury(String nazwa) {
        String osoba = "";
        int lataMax = -1000;

        try (var raf = new RandomAccessFile(nazwa, "rw")) {
            while(raf.getFilePointer() < raf.length()) {
                String imie = raf.readUTF();
                String nazwisko = raf.readUTF();
                String plec = raf.readUTF();
                String pesel = raf.readUTF();

                long wsk = raf.getFilePointer();
                int lata = raf.readInt();
                int lataDoEm = 0;
                String rokStr = "20" + pesel.substring(0, 2);
                int rok =  Integer.parseInt(rokStr);

                if (plec.equals("K")) {
                    lataDoEm = rok + 60 - 2026;
                }

                if (plec.equals("M")) {
                    lataDoEm = rok + 65 - 2026;
                }
                if (lataDoEm > lataMax) {
                    lataMax = lataDoEm;
                    osoba = imie + " " + nazwisko;
                }
                raf.seek(wsk);
                raf.writeInt(lataDoEm);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd.");
        }
        return osoba;
    }
}
