package Kolekcja2;

import java.util.Arrays;
import java.util.Scanner;

public class TotekTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wprowad� ilo�� wylosowanych liczb: ");
        int k = sc.nextInt();

        System.out.println("Wprowad� zakres od 1 do ...");
        int n = sc.nextInt();

        int[] wyniki;
        wyniki = Totek.losuj(k, n);
        System.out.println(Arrays.toString(wyniki));
    }
}
