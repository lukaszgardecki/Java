package SwitchCase;

import java.util.Scanner;

public class Oceny {
    public static void main(String[] args) {

        int ocena;
        int jedynki=0, dwojki=0, trojki=0, czworki=0, piatki=0, szostki=0, inne=0;
        Scanner skaner = new Scanner(System.in);
        System.out.println("Wprowad� oceny. \"q\" ko�czy wprowadzanie ");

        while (skaner.hasNextInt()) {
            ocena = skaner.nextInt();

            switch (ocena) {
                case 1 -> jedynki++;
                case 2 -> dwojki++;
                case 3 -> trojki++;
                case 4 -> czworki++;
                case 5 -> piatki++;
                case 6 -> szostki++;
                default -> inne++;
            }
        }
        System.out.println("Liczba jedynek: " + jedynki);
        System.out.println("Liczba dw�jek: " + dwojki);
        System.out.println("Liczba tr�jek: " + trojki);
        System.out.println("Liczba czw�rek: " + czworki);
        System.out.println("Liczba pi�tek: " + piatki);
        System.out.println("Liczba sz�stek: " + szostki);
        System.out.println("Liczba innych: " + inne);
    }
}
