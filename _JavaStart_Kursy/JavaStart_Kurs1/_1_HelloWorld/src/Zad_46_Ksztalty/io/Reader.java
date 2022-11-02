package Zad_46_Ksztalty.io;

import Zad_46_Ksztalty.exception.BrakDodatniejLiczbyException;
import Zad_46_Ksztalty.exception.MabycLiczbaOd1do3Exception;
import Zad_46_Ksztalty.model.Circle;
import Zad_46_Ksztalty.model.Rectangle;
import Zad_46_Ksztalty.model.Triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);

    public int getOption() {
        int option = 0;
        boolean condition = true;
        while(condition) {
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 3) {
                    throw new MabycLiczbaOd1do3Exception();
                }
                condition = false;
            } catch (InputMismatchException e) {
                printLine("WprowadŸ cyfrê!");
            } catch (MabycLiczbaOd1do3Exception e) {
                printLine("Wpisz cyfrê 1, 2 lub 3!");
            } finally {
                scanner.nextLine();
            }
        }
        return option;
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public Circle readCircleData() {
        printLine("Wpisz promieñ okrêgu:");
        double r = getDouble();
        return new Circle(r);
    }

    public Triangle readTriangleData() {
        printLine("Wpisz d³ugoœæ pierwszego boku:");
        double a = getDouble();
        printLine("Wpisz d³ugoœæ drugiego boku:");
        double b = getDouble();
        printLine("Wpisz d³ugoœæ trzeciego boku:");
        double c = getDouble();
        return new Triangle(a, b, c);
    }

    public Rectangle readRectangleData() {
        printLine("Wpisz d³ugoœæ pierwszego boku:");
        double a = getDouble();
        printLine("Wpisz d³ugoœæ drugiego boku:");
        double b = getDouble();
        return new Rectangle(a, b);
    }

    private double getDouble() {
        double d = 0;
        boolean isWrongNum = true;
        while(isWrongNum) {
            try {
                d = scanner.nextDouble();
                if (d <= 0) {
                    throw new BrakDodatniejLiczbyException();
                }
                isWrongNum = false;
            } catch (InputMismatchException e) {
                printLine("WprowadŸ cyfrê!");
            } catch (BrakDodatniejLiczbyException e) {
                printLine("WprowadŸ cyfrê DODATNI¥!");
            } finally {
                scanner.nextLine();
            }
        }
        return d;
    }
}
