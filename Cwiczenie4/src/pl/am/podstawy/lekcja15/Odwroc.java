package pl.am.podstawy.lekcja15;

public class Odwroc {
    public static String odwroc(String tekst) {
        String wynik = "";
        for (int i = tekst.length() - 1; i >= 0; i--) {
            wynik += tekst.charAt(i);
        }
        return wynik;
    }

    public static void main(String[] args) {
        System.out.println(odwroc("Ala ma kota"));

    }
}
