package com.example.programowanie2.cwiczenia.zaliczenia.zad8_wyznacznik_macierzy;

import java.util.Scanner;

public class Zadanie8 {
    public static void main(String[] args) {
        new WyznacznikMacierzy().run();
    }
}

class WyznacznikMacierzy {
    private final InputHandler inputHandler;
    private final Printer printer;

    WyznacznikMacierzy() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        printer.printAppInfo();
        boolean shouldContinue = true;

        try (inputHandler) {
            while (shouldContinue) {
                double a1 = inputHandler.getDoubleValue("Podaj wartość A1:");
                double b1 = inputHandler.getDoubleValue("Podaj wartość B1:");
                double c1 = inputHandler.getDoubleValue("Podaj wartość C1:");
                double a2 = inputHandler.getDoubleValue("Podaj wartość A2:");
                double b2 = inputHandler.getDoubleValue("Podaj wartość B2:");
                double c2 = inputHandler.getDoubleValue("Podaj wartość C2:");

                Result result = new UkladRownan(a1, b1, c1, a2, b2, c2).solve();
                printer.print(result);
                shouldContinue = inputHandler.getAnswer("Czy obliczyć kolejny układ równań? (t/n)");
            }
        }
        printer.println("Koniec programu.");
    }
}

class UkladRownan {
    private final double a1;
    private final double b1;
    private final double c1;
    private final double a2;
    private final double b2;
    private final double c2;

    UkladRownan(double a1, double b1, double c1, double a2, double b2, double c2) {
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.a2 = a2;
        this.b2 = b2;
        this.c2 = c2;
    }

    Result solve() {
        double w = det(new double[][]{{a1, b1}, {a2, b2}});
        double wx = det(new double[][]{{c1, b1}, {c2, b2}});
        double wy = det(new double[][]{{a1, c1}, {a2, c2}});
        return new Result(wx/w, wy/w);
    }

    private double det(double[][] t) {
        return (t[0][0] * t[1][1]) - (t[0][1] * t[1][0]);
    }
}

record Result(double x, double y) {
    @Override
    public String toString() {
        return String.format("Wynik: X = %s; Y = %s", x, y);
    }
}

class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    InputHandler(Printer printer) {
        this.printer = printer;
    }

    double getDoubleValue(String message) {
        Double result = null;
        while (result == null) {
            printer.println(message);
            try {
                var input = scanner.nextLine().trim().replace(",", ".");
                result = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                printer.printError("Błąd: Proszę wprowadzić poprawną liczbę.");
            }
        }
        return result;
    }

    boolean getAnswer(String prompt) {
        while (true) {
            printer.println(prompt);
            String sign = scanner.nextLine().trim().toLowerCase();

            if (sign.equals("t")) return true;
            if (sign.equals("n")) return false;

            printer.printError("Błąd: Wciśnij 't' lub 'n'.");
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}

class Printer {
    private final String separator = "-".repeat(41);

    void printAppInfo() {
        printSeparator();
        println("Program obliczający układ równań.");
        printSeparator();
    }

    void print(Result result) {
        System.out.println(result);
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
