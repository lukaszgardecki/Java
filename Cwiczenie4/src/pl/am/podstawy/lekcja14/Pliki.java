package pl.am.podstawy.lekcja14;

import java.io.*;
import java.util.Scanner;

public class Pliki {
    public static void main(String[] args) throws IOException {

        //Zapis do pliku:
        PrintWriter out = new PrintWriter(new FileWriter("out.txt", true));
        //napisz co� w pliku:
        out.write("hej\n");
        out.println("cze��");
        //i musimy zamkn�� ten plik:
        out.close();
        System.out.println(System.getProperty("user.dir"));


        //Odczyt z pliku:
        //FileReader fileReader;

        Scanner scanner = new Scanner(new File("plik.txt"));
        //wy�wietl tre��, je�eli nie wstawimy tego w p�tl� to wy�wietli zawarto�� pierwsze linijki. Wy�wietlaj linijki tekstu dop�ki plik posiada nastepn� linijk�:
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        //musimy zamkn��:
        scanner.close();

    }
}
