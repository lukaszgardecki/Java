package com.example.programowanie2.cwiczenia.zaliczenia.zad7_figury_ASCII;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        new FiguryAscii().run();
    }
}


class FiguryAscii {
    private final DrawService drawService;
    private final InputHandler inputHandler;
    private final Printer printer;

    FiguryAscii() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
        this.drawService = new DrawService(inputHandler, printer);
    }

    void run() {
        printer.printAppInfo();

        try (inputHandler) {
            while (true) {
                printer.printMenu();
                int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

                if (choice == MenuOption.EXIT.getId()) break;

                MenuOption.fromInt(choice).ifPresentOrElse(
                        drawService::draw,
                        () -> printer.printError("Nie ma takiej opcji!")
                );
            };
        }
        printer.println("Koniec programu.");
    }
}


enum MenuOption {
    SQUARE(1, "Kwadrat"),
    TRIANGLE_LEFT(2, "Trójkąt 1"),
    TRIANGLE_RIGHT(3, "Trójkąt 2"),
    FRAME(4, "Ramka"),
    FRAME_WITH_DIAGONALS(5, "Ramka z przekątnymi"),
    PYRAMID(6, "Piramidka"),
    EXIT(0, "Wyjście");

    private final int id;
    private final String name;

    MenuOption(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() { return id; }
    String getName() { return name; }

    static Optional<MenuOption> fromInt(int id) {
        for (MenuOption o : values()) {
            if (o.id == id) return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }
}


class DrawService {
    private final InputHandler inputHandler;
    private final Printer printer;

    DrawService(InputHandler inputHandler, Printer printer) {
        this.inputHandler = inputHandler;
        this.printer = printer;
    }

    void draw(MenuOption option) {
        printer.println("Wybrano: " + option.getName());

        int size = inputHandler.getIntegerValue("Wpisz rozmiar:");

        switch (option) {
            case SQUARE -> drawSquare(size);
            case TRIANGLE_LEFT -> drawLeftSideTriangle(size);
            case TRIANGLE_RIGHT -> drawRightSideTriangle(size);
            case FRAME -> drawFrame(size);
            case FRAME_WITH_DIAGONALS -> drawFrameWithDiagonals(size);
            case PYRAMID -> drawPyramid(size);
            default -> throw new IllegalArgumentException("Niezidentyfikowano: " + option);
        }
    }

    private void drawSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                printer.printSign();
                if (j == size - 1) printer.println();
            }
        }
    }

    private void drawLeftSideTriangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                printer.printSign();
                if (j == i) {
                    printer.println();
                    break;
                };
            }
        }
    }

    private void drawRightSideTriangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (j <= i)  printer.printSign();
                else printer.printSpace();
            }
            printer.println();
        }
    }

    private void drawFrame(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean upSide = i == 0;
                boolean downSide = i == size - 1;
                boolean leftSide = j == 0;
                boolean rightSide = j == size - 1;
                if (upSide || downSide || leftSide || rightSide) printer.printSign();
                else printer.printSpace();
            }
            printer.println();
        }
    }

    private void drawFrameWithDiagonals(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean upSide = i == 0;
                boolean downSide = i == size - 1;
                boolean leftSide = j == 0;
                boolean rightSide = j == size - 1;
                boolean diagonal1 = i == j;
                boolean diagonal2 = i == size - j - 1;
                if (upSide || downSide || leftSide || rightSide || diagonal1 || diagonal2) {
                    printer.printSign();
                } else {
                    printer.printSpace();
                }
            }
            printer.println();
        }
    }

    private void drawPyramid(int size) {
        for  (int i = size - 1; i >= 0; i--) {
            int width = size + (size - i - 1);
            for (int j = 0; j < width; j++) {
                if (j >= i) printer.printSign();
                else printer.printSpace();
            }
            printer.println();
        }
    }
}


class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    InputHandler(Printer printer) {
        this.printer = printer;
    }

    int getIntegerValue(String message) {
        Integer result = null;
        while (result == null) {
            printer.println(message);
            var input = scanner.nextLine().trim().replace(",", ".");
            try {
                result = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                printer.printError("Błąd: Proszę wprowadzić poprawną liczbę całkowitą.");
            }
        }
        return result;
    }

    @Override
    public void close() {
        scanner.close();
    }
}


class Printer {
    private final String separator = "-".repeat(41);
    private final char sign = '*';
    private final char empty = ' ';

    void printAppInfo() {
        printSeparator();
        println("Program rysujący w konsoli wybrane figury");
        printSeparator();
    }

    void printMenu() {
        Arrays.stream(MenuOption.values()).forEach(System.out::println);
        printSeparator();
    }

    void printSign() {
        System.out.print(sign);
    }

    void printSpace() {
        System.out.print(empty);
    }

    void println() {
        System.out.println();
    }

    void println(String message) {
        System.out.println(message);
    }

    void printSeparator() {
        println(separator);
    }

    void printError(String message) {
        println("\u001B[31m" + message + "\u001B[0m");
    }
}