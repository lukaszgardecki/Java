package pl.am.podstawy.lekcja14;

import java.io.*;
import java.util.Scanner;

public class Pliki {
    public static void main(String[] args) throws IOException {

        //Zapis do pliku:
        PrintWriter out = new PrintWriter(new FileWriter("out.txt", true));
        //napisz coœ w pliku:
        out.write("hej\n");
        out.println("czeœæ");
        //i musimy zamkn¹æ ten plik:
        out.close();
        System.out.println(System.getProperty("user.dir"));


        //Odczyt z pliku:
        //FileReader fileReader;

        Scanner scanner = new Scanner(new File("plik.txt"));
        //wyœwietl treœæ, je¿eli nie wstawimy tego w pêtlê to wyœwietli zawartoœæ pierwsze linijki. Wyœwietlaj linijki tekstu dopóki plik posiada nastepn¹ linijkê:
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        //musimy zamkn¹æ:
        scanner.close();

    }
}
