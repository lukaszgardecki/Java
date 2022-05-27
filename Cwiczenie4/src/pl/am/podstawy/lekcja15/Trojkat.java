package pl.am.podstawy.lekcja15;

public class Trojkat {
    public static String generuj(String znak, int ilosc) {
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < ilosc; i++) {
            wynik.append(znak);
        }
        return wynik.toString();
    }

    public static void generujTrojkat(int rozmiar, String znak) {
        for (int i = 1; i <= rozmiar; i++) {
            System.out.println(generuj(znak,i));
        }
    }

    public static void generujPiramide(int rozmiar, String znak) {
        for (int i = 1; i <= rozmiar; i++) {
            System.out.println(generuj(" ", rozmiar-i) + generuj(znak,2*i-1));
        }
    }

    public static void main(String[] args) {
        //generujTrojkat(20,".");
        generujPiramide(40,"*");
    }
}
