package SwitchCase;

import java.util.Scanner;

public class Oceny {
    public static void main(String[] args) {

        int ocena;
        int jedynki=0, dwojki=0, trojki=0, czworki=0, piatki=0, szostki=0, inne=0;
        Scanner skaner = new Scanner(System.in);
        System.out.println("WprowadŸ oceny. \"q\" koñczy wprowadzanie ");

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
        System.out.println("Liczba dwójek: " + dwojki);
        System.out.println("Liczba trójek: " + trojki);
        System.out.println("Liczba czwórek: " + czworki);
        System.out.println("Liczba pi¹tek: " + piatki);
        System.out.println("Liczba szóstek: " + szostki);
        System.out.println("Liczba innych: " + inne);
    }
}
