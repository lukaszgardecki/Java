package com.example.programowanie2.cwiczenia.zaliczenia.zad18_pliki_danych;

import java.io.*;

class Zadanie18 {
    public static void main(String[] args) {
        new PlikiDanych().run();
    }
}


class PlikiDanych {
    void run() {
        System.out.println("Zadanie 1");
        new Towary().run();

        System.out.println("Zadanie 2");
        new Domy().run();

        System.out.println("Zadanie 3");
        new Obliczenia().run();
    }
}


class Towary {

    void run() {
        String szukanyTowar = "Kawa";
        int sztuki = przetwarzajPlik("przetwarzaj_plik.bin", szukanyTowar);
        System.out.printf("Liczba sztuk towaru %s: %d%n", szukanyTowar, sztuki);
    }

    private int przetwarzajPlik(String nazwaPliku, String nazwaTowaru) {
        int liczbaSztukSzukanegoTowaru = 0;
        int licznikTrojek = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(nazwaPliku))) {
            while (dis.available() > 0) {
                dis.readUTF();
                dis.readDouble();
                dis.readInt();
                licznikTrojek++;
            }
        } catch (EOFException e) {
            System.out.println("Osiągnięto koniec pliku.");
        } catch (IOException e) {
            System.out.println("Błąd odczutu: " + e.getMessage());
        }

        if (licznikTrojek == 0) {
            System.out.println("Plik wejściowy jest pusty.");
            return 0;
        }

        String[] nazwy = new String[licznikTrojek];
        double[] ceny = new double[licznikTrojek];
        int[] sztuki = new int[licznikTrojek];

        try (DataInputStream dis = new DataInputStream(new FileInputStream(nazwaPliku))) {
            for (int i = 0; i < licznikTrojek; i++) {
                nazwy[i] = dis.readUTF();
                ceny[i] = dis.readDouble();
                sztuki[i] = dis.readInt();
            }

            for (int i = 0; i < licznikTrojek; i++) {
                if (nazwy[i].equals(nazwaTowaru)) {
                    liczbaSztukSzukanegoTowaru = sztuki[i];
                }

                if (sztuki[i] >= 100) {
                    ceny[i] = ceny[i] * 0.9;
                }
            }
        } catch (EOFException e) {
            System.out.println("Osiągnięto koniec pliku.");
        } catch (IOException e) {
            System.out.println("Błąd odczutu: " + e.getMessage());
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nazwaPliku))) {
            for (int i = 0; i < licznikTrojek; i++) {
                dos.writeUTF(nazwy[i]);
                dos.writeDouble(ceny[i]);
                dos.writeInt(sztuki[i]);
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }

        return liczbaSztukSzukanegoTowaru;
    }
}


class Domy {

    void run() {
        String nazwaPliku = "domy2.bin";

        System.out.println("--- Domy przed obniżką ---");
        wyswietlPlik(nazwaPliku);

        obnizCenyDomowParterowychNaWsiWPliku(nazwaPliku);

        System.out.println("--- Domy po obniżce ---");
        wyswietlPlik(nazwaPliku);

//        dopiszDomDoPliku(nazwaPliku, new Dom("Dom1", 1, 20000.0, "wies"));
//        dopiszDomDoPliku(nazwaPliku, new Dom("Dom2", 4, 40000.0, "wies"));
//        dopiszDomDoPliku(nazwaPliku, new Dom("Dom3", 5, 30000.0, "miasto"));
//        dopiszDomDoPliku(nazwaPliku, new Dom("Dom4", 1, 10000.0, "wies"));
//        dopiszDomDoPliku(nazwaPliku, new Dom("Dom5", 6, 50000.0, "miasto"));
    }

    private void obnizCenyDomowParterowychNaWsiWPliku(String nazwaPliku) {
        try(RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                String nazwa = raf.readUTF();
                int kondygnacje = raf.readInt();

                long pozycjaCeny = raf.getFilePointer();
                double cena = raf.readDouble();

                String lokalizacja = raf.readUTF();

                if (kondygnacje == 1 && "wies".equalsIgnoreCase(lokalizacja)) {
                    double nowaCena = cena * 0.9;
                    long pozycjaKoncowa = raf.getFilePointer();

                    raf.seek(pozycjaCeny);
                    raf.writeDouble(nowaCena);
                    raf.seek(pozycjaKoncowa);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private void dopiszDomDoPliku(String nazwaPliku, Dom dom) {
        try(RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            raf.seek(raf.length());

            raf.writeUTF(dom.nazwa());
            raf.writeInt(dom.kondygnacje());
            raf.writeDouble(dom.cena());
            raf.writeUTF(dom.lokalizacja());
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private void wyswietlPlik(String nazwaPliku) {
        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "r")) {
            while(raf.getFilePointer() < raf.length()) {
                String nazwa = raf.readUTF();
                int kondygnacje = raf.readInt();
                double cena = raf.readDouble();
                String lokalizacja = raf.readUTF();
                System.out.printf("Dom: %s, Kondygnacje: %d, Cena: %.2f, Lokalizacja: %s%n", nazwa, kondygnacje, cena, lokalizacja);
            }
        } catch (IOException ex) {
            System.out.println("Brak pliku");
        }
    }

    private record Dom(String nazwa, int kondygnacje, double cena, String lokalizacja) { }
}


class Obliczenia {

    void run() {
        String nazwaPliku = "obliczenia.bin";
        zapiszObliczeniaDoPliku(nazwaPliku, new double[]{ 3.14, 2.17, 4.5, 3.1, 2.0, 7.15 });

        System.out.println("--- Zawartość pliku przed analizą ---");
        wyswietlPlik(nazwaPliku);

        analizujPlik(nazwaPliku);

        System.out.println("--- Zawartość pliku po analizie ---");
        wyswietlPlik(nazwaPliku);
    }

    private void analizujPlik(String nazwaPliku) {
        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            double wynik = 0.0;
            while(raf.getFilePointer() < raf.length()) {
                double iloscElementow = raf.readDouble();
                wynik = raf.readDouble();

                for(int i = 1; i < iloscElementow; i++) {
                    double liczba = raf.readDouble();
                    if (i % 2 != 0) wynik += liczba;
                    else wynik -= liczba;
                }
            }

            raf.writeDouble(wynik);
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private void zapiszObliczeniaDoPliku(String nazwaPliku, double[] liczby) {
        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            raf.setLength(0);
            raf.seek(0);

            raf.writeDouble(liczby.length);
            for (double v : liczby) {
                raf.writeDouble(v);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private void wyswietlPlik(String nazwaPliku) {
        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "r")) {
            while(raf.getFilePointer() < raf.length()) {
                System.out.println(raf.readDouble());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }
}