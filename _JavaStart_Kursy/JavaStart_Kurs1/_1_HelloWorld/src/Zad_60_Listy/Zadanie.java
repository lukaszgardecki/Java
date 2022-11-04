package Zad_60_Listy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Zadanie {
    private static List<Integer> numbers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int sum = readNumbers();
        System.out.printf("Wpisane liczby to:%n%s%n", numbers);
        System.out.println("Suma wszystkich liczb to: " + sum);
    }

    private static int readNumbers() {
        System.out.println("Wpisz liczbê lub \"exit\", aby wyjœæ:");
        String input = scanner.nextLine().toLowerCase();

        if (input.equals("exit")) return 0;
        else {
            int num = Integer.parseInt(input);
            numbers.add(num);
            return num + readNumbers();
        }
    }
}
