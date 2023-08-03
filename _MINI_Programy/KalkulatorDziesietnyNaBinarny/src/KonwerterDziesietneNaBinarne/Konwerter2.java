package KonwerterDziesietneNaBinarne;

import java.util.Scanner;

public class Konwerter2 {

            // KONWERTER 2.  Inne podejœcie. Wynik nadal jest Stringiem

    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        long modulo;
        String wynik = "";

        System.out.println(" * * * KONWERTER LICZB DZIESIÊTNYCH NA BINARNE * * * ");
        System.out.println("Wpisz liczbê ca³kowit¹:");
        long liczbaWprowadzona = skaner.nextInt();
        long liczba = liczbaWprowadzona;


        do {
            //oblicz resztê z dzielenia wprowadzonej liczby przez 2:
            modulo = liczba%2;
            //podziel liczbê przez 2 i przypisz j¹ do "liczby". Typ long ingnoruje wartoœci po przecinku:
            liczba = liczba/2;
            //do zmiennej "wynik" przypisuj kolejno reszty z dzielenia (tworzy siê 'odwrócona' liczba binarna)
           wynik += modulo;

        } while (liczba >= 1);
            //otrzymany wynik nale¿y odwróciæ:
        wynik = new StringBuilder(wynik).reverse().toString();

        System.out.println("Liczba " + liczbaWprowadzona + " w systemie dwójkowym (binarnym) to: " + wynik);

    }
}
