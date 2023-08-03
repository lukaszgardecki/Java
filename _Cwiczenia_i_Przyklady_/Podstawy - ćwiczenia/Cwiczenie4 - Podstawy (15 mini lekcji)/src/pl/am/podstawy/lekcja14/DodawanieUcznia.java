package pl.am.podstawy.lekcja14;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DodawanieUcznia {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwisko ucznia: ");
        String nazwisko = scanner.next();
        System.out.println("Podaj ocen� tego ucznia: ");
        int ocena = scanner.nextInt();

        PrintWriter out = new PrintWriter(new FileWriter("lista.txt", true));
        //napisz co� w pliku:
        out.print("\n" + nazwisko + " " + ocena);
        //i musimy zamkn�� ten plik:
        out.close();
    }
}
