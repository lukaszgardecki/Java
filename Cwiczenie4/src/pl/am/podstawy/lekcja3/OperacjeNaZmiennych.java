package pl.am.podstawy.lekcja3;

import java.util.Arrays;

public class OperacjeNaZmiennych {
    public static void main(String[] args) {
        System.out.println("Operacje na zmiennych");

        //deklaracja zmiennej
        int x;

        // to jest inicjalizacja
        x=30;
        System.out.println("x =" + x);
        x=31;
        System.out.println("x =" + x);

        //deklaracje
        int y;
        int z;

        //wielokrotna deklaracja
        int x1, x2, x3;

        //deklaracje z inicjalizacją
        int zmienna = 4;
        int y1, y2 = 45, y3;
        y1 = y2;
        x1 = x2 = x3 = 5;

        int suma = 1 + 1;
        System.out.println("suma = " + suma);

        x = x + 10;
        System.out.println("x = " + x);

        zmienna += 6;
        System.out.println("zmienna = " + zmienna);

        //zmienna += 6;
        //zmienna *= 3;
        //zmienna /= 2;
        //zmienna -= 1;
        //zmienna %= 3;

        zmienna = zmienna + 1;
        zmienna += 1;

        //inkrementacja:
        zmienna++;

        //dekrementacja:
        zmienna--;

        System.out.println("zmienna = " + zmienna);

        int i = 10;
        int d = 10;

        i++;
        System.out.println("i = " + i);
        System.out.println("i = " + ++i);

        d--;
        System.out.println("d = " + d);
        System.out.println("d = " + --d);

        int wynik = 2 + 2 * 2; //=6
        System.out.println("wynik = " + wynik);

        byte zmiennaByte = 127;
        short zmiennaShort = 1234;
        int zmiennaInt = 54321;
        long zmiennaLond = 2_000_000_000L;

        float zminnaFloat = 12.34F;
        double zmiennaDouble = 12.34D;

        boolean zmiennaBoolean1 = true;
        boolean zmiennaBoolean2 = false;

        char zmiennaChar = 'A';
        String zmiennaString = "Tekst";



    }
}
