package Zad_24_RzutMoneta;

import java.util.Random;
import java.util.Scanner;

public class Rzut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while(true) {

            int ranNum = random.nextInt(2);

            System.out.println("Wybierz jedn� z dw�ch opcji:");
            System.out.println("1 - orze�");
            System.out.println("0 - reszka");

            int userNum = scanner.nextInt();

            if (ranNum == 0 && userNum == 0) {
                System.out.println("Brawo, wypad�a reszka i wygrywasz!");
            } else if (ranNum == 0 && userNum == 1) {
                System.out.println("Niestety przegrywasz! Wypad�a reszka!");
            } else if (ranNum == 1 && userNum == 1) {
                System.out.println("Brawo, wypad� orze� i wygrywasz!");
            } else if (ranNum == 1 && userNum == 0) {
                System.out.println("Niestety przegrywasz! Wypad� orze�!");
            }
        }


    }
}
