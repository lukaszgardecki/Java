package Zad_69_Collections;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class TotalizatorApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Lotto lotto = new Lotto();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println("Witamy w totalizatorze sportowym!");
        while(true) {
            System.out.println("""
                    Wybierz opcjê:
                        0 - wyjœcie z programu
                        1 - zagraj""");
            int option = getOption();
            switch (option) {
                case 0 -> exit();
                case 1 -> play();
                default -> System.out.println("Wpisz liczbê ale OD 1 DO 49 !!!");
            }
        }
    }

    private static void exit() {
        System.out.println("Zamykanie programu.");
        System.exit(0);
    }

    private static int getOption() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wpisz LICZBÊ!");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private static void play() {
        lotto.generate();
        List<Integer> list = getNumsFromUser();
        int luckyNums = lotto.checkResult(list);
        System.out.printf("Wynik losowania: %s%n", lotto.getList());
        System.out.printf("Liczby skreœlone przez u¿ytkownika: %s%n", list);
        System.out.printf("Liczba trafieñ: %d%n", luckyNums);
    }

    private static List<Integer> getNumsFromUser() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int num = getNum(i);
            list.add(num);
        }
        return list;
    }

    private static int getNum(int i) {
        System.out.print(i + ") Podaj liczbê 1-49:");
        while(true) {
            try {
                int num = scanner.nextInt();

                if (num > 0 && num <= 49) {
                    return num;
                } else throw new InputMismatchException();

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Podaj LICZBÊ!");
                System.out.println();
                System.out.print(i + ") Podaj liczbê 1-49:");
            }
        }
    }

}
