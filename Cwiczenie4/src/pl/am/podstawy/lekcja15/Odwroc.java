package pl.am.podstawy.lekcja15;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Odwroc {
    public static String odwroc(String tekst) {
        StringBuilder wynik = new StringBuilder(tekst);
        wynik.reverse();
        return wynik.toString();
    }

    public static String generuj(String znak, int ilosc) {
        String wynik = "";
        for (int i = 0; i < ilosc; i++) {
            wynik += znak;
        }
        return wynik;
    }

    public static String generuj2(String znak, int ilosc) {
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < ilosc; i++) {
            wynik.append(znak);
        }
        return wynik.toString();
    }

    public static void main(String[] args) {
        //zaczynamy mierzyæ czas:
        long start = System.currentTimeMillis();

        //wykonujemy metodê
        System.out.println(generuj2(".",100000));

        //koniec czasu:
        long stop = System.currentTimeMillis();

        long czas = stop - start;
        System.out.println("czas = " + czas);



    }
}
