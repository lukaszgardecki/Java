package KonwerterDziesietneNaBinarne;

import java.util.Scanner;

public class Konwerter2 {

            // KONWERTER 2.  Inne podej�cie. Wynik nadal jest Stringiem

    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        long modulo;
        String wynik = "";

        System.out.println(" * * * KONWERTER LICZB DZIESI�TNYCH NA BINARNE * * * ");
        System.out.println("Wpisz liczb� ca�kowit�:");
        long liczbaWprowadzona = skaner.nextInt();
        long liczba = liczbaWprowadzona;


        do {
            //oblicz reszt� z dzielenia wprowadzonej liczby przez 2:
            modulo = liczba%2;
            //podziel liczb� przez 2 i przypisz j� do "liczby". Typ long ingnoruje warto�ci po przecinku:
            liczba = liczba/2;
            //do zmiennej "wynik" przypisuj kolejno reszty z dzielenia (tworzy si� 'odwr�cona' liczba binarna)
           wynik += modulo;

        } while (liczba >= 1);
            //otrzymany wynik nale�y odwr�ci�:
        wynik = new StringBuilder(wynik).reverse().toString();

        System.out.println("Liczba " + liczbaWprowadzona + " w systemie dw�jkowym (binarnym) to: " + wynik);

    }
}
