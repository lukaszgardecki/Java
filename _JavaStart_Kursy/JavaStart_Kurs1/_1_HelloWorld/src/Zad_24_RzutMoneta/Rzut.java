package Zad_24_RzutMoneta;

import java.util.Random;
import java.util.Scanner;

public class Rzut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while(true) {

            int ranNum = random.nextInt(2);

            System.out.println("Wybierz jedn¹ z dwóch opcji:");
            System.out.println("1 - orze³");
            System.out.println("0 - reszka");

            int userNum = scanner.nextInt();

            if (ranNum == 0 && userNum == 0) {
                System.out.println("Brawo, wypad³a reszka i wygrywasz!");
            } else if (ranNum == 0 && userNum == 1) {
                System.out.println("Niestety przegrywasz! Wypad³a reszka!");
            } else if (ranNum == 1 && userNum == 1) {
                System.out.println("Brawo, wypad³ orze³ i wygrywasz!");
            } else if (ranNum == 1 && userNum == 0) {
                System.out.println("Niestety przegrywasz! Wypad³ orze³!");
            }
        }


    }
}
