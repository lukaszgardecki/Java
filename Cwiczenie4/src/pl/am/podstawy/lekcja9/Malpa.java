package pl.am.podstawy.lekcja9;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Malpa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] plansza = {
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'}
        };

        int malpaK = 8;
        int malpaW = 1;

        //System.out.println(plansza.length);
        //System.out.println(plansza[malpaK].length);


        plansza[malpaW][malpaK] = '@';

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(plansza[i][j]);
            }
            System.out.println();
        }

        while (true){
            String kierunek =  scanner.nextLine();
            plansza[malpaW][malpaK] = '.';


//        if (kierunek.equals("w")) {
//            malpaW--;
//        } else if (kierunek.equals("s")) {
//            malpaW++;
//        } else if (kierunek.equals("a")) {
//            malpaK--;
//        } else if (kierunek.equals("d")) {
//            malpaK++;
//        }

            switch (kierunek) {
                case "w":
                case "W":
                    //If zabezpiecza malpe przed wyjsciem poza planszę
                    if (malpaW > 0) {
                        malpaW--;
                        break;
                    } else
                        break;

                case "s":
                case "S":
                    //If zabezpiecza malpe przed wyjsciem poza planszę
                    if (malpaW < plansza.length - 1) {
                        malpaW++;
                        System.out.println(malpaW);
                        break;

                    } else
                        break;
                case "a":
                case "A":
                    //If zabezpiecza malpe przed wyjsciem poza planszę
                    if (malpaK > 0) {
                        malpaK--;
                        break;
                    } else
                        break;
                case "d":
                case "D":
                    //If zabezpiecza malpe przed wyjsciem poza planszę
                    if (malpaK < plansza[malpaW].length - 1) {
                        malpaK++;
                        break;
                    } else
                        break;

            }

            plansza[malpaW][malpaK] = '@';

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(plansza[i][j]);
                }
                System.out.println();


            }
        }

    }
}
