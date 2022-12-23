package app;

import app.shapes.Rectangle;
import app.shapes.Square;
import app.shapes.Tree;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interfejs Drawable definiuje kształty, które można "rysować" w konsoli przy pomocy znaku '*' (gwiazdka).
 * Interfejs ten posiada tylko jedną metodę:
 *
 * void draw();
 *
 * Zdefiniuj klasy:
 *
 *     Square (kwadrat) - posiada długość boku,
 *     Rectangle (prostokąt) - posiada boki a i b,
 *     Tree (drzewo) - posiada wysokość,
 *
 * które implementują interfejs Drawable. Następnie wczytaj od użytkownika dane dotyczącego jakiegoś kształtu i wyświetl ten kształt na ekranie.
 *
 * Na potrzeby zadania operujemy na liczbach całkowitych.
 */

public class Test {
    private static final String RECTANGLE = "rectangle";
    private static final String SQUARE = "square";
    private static final String TREE = "tree";
    private static final String NIC = "nic";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Co chcesz narysować? (rectangle / square / tree / nic)");
            switch (scanner.nextLine().toLowerCase()) {
                case RECTANGLE -> drawRectangle();
                case SQUARE -> drawSquare();
                case TREE -> drawTree();
                case NIC -> System.exit(0);
                default -> System.out.println("Nie potrafię tego narysować!");
            }
        }
    }

    private static void drawTree() {
        System.out.println("Podaj wysokość choinki:");
             int h = getInt();
             new Tree(h).draw();
    }

    private static void drawSquare() {
        System.out.println("Podaj długość boku:");
        int a = getInt();
        new Square(a).draw();
    }

    private static void drawRectangle() {
        System.out.println("Podaj długość pierwszego boku:");
        int a = getInt();
        System.out.println("Podaj długość drugiego boku:");
        int b = getInt();
        new Rectangle(a, b).draw();
    }

    private static int getInt() {
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wpisz LICZBĘ CAŁKOWITĄ!");
            }
            scanner.nextLine();
        }
        return num;
    }
}
