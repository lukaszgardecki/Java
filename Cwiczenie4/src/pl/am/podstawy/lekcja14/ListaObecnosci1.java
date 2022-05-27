package pl.am.podstawy.lekcja14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaObecnosci1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("lista.txt"));

        float suma = 0;
        int numer = 0;
        //wyświetl treść, jeżeli nie wstawimy tego w pętlę to wyświetli zawartość pierwsze linijki. Wyświetlaj linijki tekstu dopóki plik posiada nastepną linijkę:
        while (scanner.hasNext()) {
            numer++;
            String nazwisko = scanner.next();
            int ocena = scanner.nextInt();
            suma += ocena;
            System.out.println(numer + " " + nazwisko + ", ocena: " + ocena);
        }
        System.out.println("średnia z matematyki: " + suma/numer);



    }
}
