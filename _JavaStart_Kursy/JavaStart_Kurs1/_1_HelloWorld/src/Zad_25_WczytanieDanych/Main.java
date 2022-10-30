package Zad_25_WczytanieDanych;

import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Ile liczb chcesz wprowadziæ?");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            sum += scanner.nextInt();
        }
        System.out.println("Suma wszystkich liczb to " + sum);
    }
}
