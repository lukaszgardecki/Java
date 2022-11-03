package Zad_57_Porownanienapisow;

import java.util.Arrays;
import java.util.Scanner;

class Zadanie {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj napis 1:");
        String[] word1 = scanner.nextLine().toLowerCase().split("");

        System.out.println("Podaj napis 2:");
        String[] word2 = scanner.nextLine().toLowerCase().split("");

        Arrays.sort(word1);
        Arrays.sort(word2);

        if (Arrays.equals(word1, word2)) {
            System.out.println("Napisy sk³adaj¹ siê z tych samych liter");
        } else {
            System.out.println("Napisy NIE sk³adaj¹ siê z tych samych liter");
        }
    }
}
