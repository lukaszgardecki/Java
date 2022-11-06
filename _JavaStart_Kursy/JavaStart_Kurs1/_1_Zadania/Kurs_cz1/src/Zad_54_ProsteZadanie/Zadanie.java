package Zad_54_ProsteZadanie;

import java.util.Scanner;

class Zadanie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dowolny tekst z literami i cyframi:");
        String text = scanner.nextLine();

        System.out.printf("Liczba cyfr w tekœcie: %s%n", getNumOfDigits(text));
        System.out.printf("Liczba liter w tekœcie: %s%n", getNumOfLetters(text));
        if (getBiggestDigit(text) > 0) {
            System.out.printf("Najwiêksza cyfra w tekœcie to %s%n", getBiggestDigit(text));
        } else {
            System.out.println("Brak cyfr w tekœcie.");
        }
    }

    private static int getBiggestDigit(String text) {
        int num = 0;
        for (int i = 0; i < text.length(); i++) {

            if (Character.isDigit(text.charAt(i))) {
                int n = Integer.parseInt(String.valueOf(text.charAt(i)));
                if (n > num) num = n;
            }
        }
        return num;
    }

    private static int getNumOfLetters(String text) {
        int num = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) num++;
        }
        return num;
    }

    private static int getNumOfDigits(String text) {
        int num = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) num++;
        }
        return num;
    }
}
