package com.example.programowanie2.cwiczenia.zaliczenia.zad8_uklad_rownan;

import java.util.Scanner;

public class Zadanie_8 {
    public static void main(String[] args) {
        new ProgramRozwiazujacyUkladRownan().run();
    }
}


class ProgramRozwiazujacyUkladRownan {
    private final InputHandler inputHandler;
    private final Printer printer;

    ProgramRozwiazujacyUkladRownan() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        printer.printAppInfo();
        boolean shouldContinue = true;

        try (inputHandler) {
            while (shouldContinue) {
                var uklad = stworzUkladRownan();
                var wynik = uklad.rozwiaz();
                printer.print(wynik);

                printer.printSeparator();
                shouldContinue = inputHandler.getAnswer("Czy obliczyć kolejny układ równań? (t/n)");
                printer.printSeparator();
            }
        }
        printer.println("Koniec programu.");
    }

    private UkladRownan stworzUkladRownan() {
        printer.println("--- Równanie 1 ---");
        var rownanie1 = new Rownanie(
                inputHandler.getDoubleValue("Podaj wartość A:"),
                inputHandler.getDoubleValue("Podaj wartość B:"),
                inputHandler.getDoubleValue("Podaj wartość C:")
        );

        printer.println("--- Równanie 2 ---");
        var rownanie2 = new Rownanie(
            inputHandler.getDoubleValue("Podaj wartość A:"),
            inputHandler.getDoubleValue("Podaj wartość B:"),
            inputHandler.getDoubleValue("Podaj wartość C:")
        );

        return new UkladRownan(rownanie1, rownanie2);
    }
}


record Rownanie(double a, double b, double c) {}


class UkladRownan {
    private final Rownanie rownanie1, rownanie2;

    UkladRownan(Rownanie rownanie1, Rownanie rownanie2) {
        this.rownanie1 = rownanie1;
        this.rownanie2 = rownanie2;
    }

    Result rozwiaz() {
        double w = det(new double[][]{{rownanie1.a(), rownanie1.b()}, {rownanie2.a(), rownanie2.b()}});
        double wx = det(new double[][]{{rownanie1.c(), rownanie1.b()}, {rownanie2.c(), rownanie2.b()}});
        double wy = det(new double[][]{{rownanie1.a(), rownanie1.c()}, {rownanie2.a(), rownanie2.c()}});

        Result result;
        if (w != 0) result = new Result(wx/w, wy/w, TypRozwiazania.JEDNO);
        else if (wx == 0 && wy == 0) result = new Result(0, 0, TypRozwiazania.NIESKONCZONOSC);
        else result = new Result(0, 0, TypRozwiazania.BRAK);
        return result;
    }

    private double det(double[][] t) {
        return (t[0][0] * t[1][1]) - (t[0][1] * t[1][0]);
    }
}


enum TypRozwiazania {
    JEDNO, NIESKONCZONOSC, BRAK
}


record Result(double x, double y, TypRozwiazania typRozwiazania) {
    @Override
    public String toString() {
        return """
                X = %s
                Y = %s"""
                .formatted(x, y);
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
        switch (result.typRozwiazania()) {
            case JEDNO -> println("Układ posiada jedno rozwiązanie:\n" + result);
            case NIESKONCZONOSC -> println("Układ nieoznaczony - posiada nieskończenie wiele rozwiązań.");
            case BRAK -> println("Układ sprzeczny - brak rozwiązań.");
        }
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
