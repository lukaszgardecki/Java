package pl.am.podstawy.lekcja7;

import java.util.Scanner;

public class Rozgrzewka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj zdanie.");
        String zdanie = scanner.nextLine();

        System.out.println("Ile razy powtorzyc zdanie?");
        int ilosc = scanner.nextInt();

        for (int i = 1; i <= ilosc; i++) {
            System.out.println(i + ". " + zdanie);
        }
    }
}
