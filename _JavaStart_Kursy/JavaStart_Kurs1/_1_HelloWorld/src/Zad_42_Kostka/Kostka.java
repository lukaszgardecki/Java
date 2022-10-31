package Zad_42_Kostka;

import java.util.Random;
import java.util.Scanner;

class Kostka {
    static String[] diceSides;


    public static void main(String[] args) {
        createDiceSides();
        while (true) {
            takeEnter();
            int num = getNum();
            drawDice(num);
        }
    }

    private static void createDiceSides() {
        diceSides = new String[6];

        diceSides[0] = " - - - - - \n|         |\n|    0    |\n|         |\n - - - - - ";
        diceSides[1] = " - - - - - \n|    0    |\n|         |\n|    0    |\n - - - - - ";
        diceSides[2] = " - - - - - \n|    0    |\n|    0    |\n|    0    |\n - - - - - ";
        diceSides[3] = " - - - - - \n| 0     0 |\n|         |\n| 0     0 |\n - - - - - ";
        diceSides[4] = " - - - - - \n| 0     0 |\n|    0    |\n| 0     0 |\n - - - - - ";
        diceSides[5] = " - - - - - \n| 0     0 |\n| 0     0 |\n| 0     0 |\n - - - - - ";
    }

    private static void takeEnter() {
        System.out.println("Wciœnij Enter, aby rzuciæ kostk¹");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static int getNum() {
        Random random = new Random();
        return random.nextInt(6);
    }

    private static void drawDice(int num) {
        System.out.println(diceSides[num]);
    }

}
