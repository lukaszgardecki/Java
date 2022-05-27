package pl.am.podstawy.lekcja9;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Malpa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //wersja 1 - z góry okreslony wymiar planszy
//        char[][] plansza = {
//                {'.','.','.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','.','.','.'}
//        };

        //wersja 2 - wymiar planszy określa użytkownik:
        System.out.println("--- Podaj wymiary planszy ---");
        System.out.println("Ilosc wierszy: ");
        int ileWierszy = scanner.nextInt();

        System.out.println("Ilosc kolumn: ");
        int ileKolumn = scanner.nextInt();

        char[][] plansza = new char[ileWierszy][ileKolumn];

        for (int i = 0; i < ileWierszy; i++) {
            for (int j = 0; j < ileKolumn; j++) {
                plansza[i][j] = '.';
            }
        }

        // lokalizacja małpy na starcie programu
        int malpaK = ileKolumn/2;
        int malpaW = ileWierszy/2;
        plansza[malpaW][malpaK] = '@';

        //Dodanie pustych linijek w konsoli
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[malpaW].length; j++) {
                System.out.print(plansza[i][j]);
            }
            System.out.println();
        }

        //całość w nieskończonej pętli żeby non stop działało
        while (true){
            String kierunek =  scanner.nextLine();
            plansza[malpaW][malpaK] = '.';


            //Po nacisnięciu klawisza zmień kierunek:
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

            //Dodanie pustych linijek w konsoli
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            for (int i = 0; i < plansza.length; i++) {
                for (int j = 0; j < plansza[malpaW].length; j++) {
                    System.out.print(plansza[i][j]);
                }
                System.out.println();
            }
        }

    }
}
