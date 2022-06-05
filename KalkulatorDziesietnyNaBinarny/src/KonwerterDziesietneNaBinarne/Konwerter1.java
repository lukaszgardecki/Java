package KonwerterDziesietneNaBinarne;

import java.util.Scanner;

public class Konwerter1 {

            // KONWERTER. Podej�cie 1. Wynik jest Stringiem

    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);


        System.out.println(" * * * KONWERTER LICZB DZIESI�TNYCH NA BINARNE * * * ");
        System.out.println("Wpisz liczb� ca�kowit�:");
        long skan = skaner.nextLong();

        double bi;
        double x = (int) (Math.log(skan) / Math.log(2));
        double liczba = skan;
        String wynik = "";

        if (skan > 0) {
            for (double i = x; i >= 0; i--) {
                bi = Math.pow(2, i);
                if (liczba - bi >= 0) {
                    wynik += "1";
                    liczba = liczba - bi;
                } else {
                    wynik += "0";
                }
            }
        } else {
            wynik = "0";
        }

        System.out.println("Liczba " + skan + " w systemie dw�jkowym (binarnym) to: " + wynik);
    }
}
