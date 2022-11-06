package Zad_61_Listy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Zadanie {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> numbers = new ArrayList<>();
    private static double average = 0;
    private static double counter = 0;

    public static void main(String[] args) {
        int sum = readNumbers();

        System.out.println("Poprawnie wprowadzone liczby: " + numbers );
        System.out.println("Iloœæ poprawnych liczb: " + (int)counter);
        System.out.println("Ich suma wynosi: " + sum);
        System.out.printf("Natomiast œrednia to: %.1f%n", average);
    }

    private static int readNumbers() {
        return count(counter);
    }

    private static int count(double i) {
        System.out.println("Podaj kolejn¹ liczbê nieujemn¹, podzieln¹ przez 5:");
        int num = scanner.nextInt();

        if (num >= 0 && num % 5 == 0) {
            counter++;
            numbers.add(num);
            int sum = num + count(i + 1);
            average = sum / counter;
            return sum;
        }
        return 0;
    }
}
