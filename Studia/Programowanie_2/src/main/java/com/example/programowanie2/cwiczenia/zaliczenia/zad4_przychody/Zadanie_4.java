package com.example.programowanie2.cwiczenia.zaliczenia.zad4_przychody;

import java.util.Scanner;

public class Zadanie_4 {
    public static void main(String[] args) {
        new RocznePrzychody().run();
    }
}

class RocznePrzychody {
    private final InputHandler inputHandler;
    private final Printer printer;

    RocznePrzychody() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        printer.printAppInfo();
        Incomes incomes = new Incomes();
        MonthsCount monthsCount = setupMonthsCount();

        try(inputHandler) {
            for (int i = 0; i < monthsCount.value(); i++) {
                double income = inputHandler.getPositiveDoubleValue("Podaj przychód " + (i+1) + ": ");
                incomes.count(income);
            }
        }

        printer.printSeparator();
        printer.print(incomes);
        printer.printSeparator();
        printer.println("Koniec programu.");
    }

    MonthsCount setupMonthsCount() {
        MonthsCount monthsCount = new MonthsCount();
        printer.printf("Aktualny okres rozliczeniowy to %d miesięcy.\n", monthsCount.value());

        boolean wybierzOkres = inputHandler.getAnswer("Czy chcesz zmienić ten zakres? (t/n)");
        if (!wybierzOkres) return monthsCount;

        int iloscMiesiecy;

        while (true) {
            iloscMiesiecy = inputHandler.getIntegerValue("Podaj liczbę miesięcy, dla której chcesz wprowadzić przychody:");
            try {
                return new MonthsCount(iloscMiesiecy);
            } catch (IllegalArgumentException e) {
                printer.printError("Błąd: Liczba musi być >= 1.");
            }
        }
    }
}

record MonthsCount(int value){
    MonthsCount() {
        this(12);
    }

    MonthsCount {
        if (value < 1) throw new IllegalArgumentException();
    }
}

class Incomes {
    private double sum;
    private double count;
    private double average;

    private double min = Double.MAX_VALUE;
    private double max = -Double.MAX_VALUE;

    void count(double value) {
        sum += value;
        count++;
        average = sum / count;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    @Override
    public String toString() {
        return String.format("""
        Suma dochodów: %.2fzł
        Dochód średni: %.2fzł
        Dochód minimalny: %.2fzł
        Dochód maksymalny: %.2fzł
        """,
                sum, average, min, max);
    }
}

class Printer {
    private final String separator = "-".repeat(69);

    void printAppInfo() {
        printSeparator();
        println("Przychody roczne");
        printSeparator();
    }

    void print(Incomes incomes) {
        println(incomes.toString());
    }

    void println(String message) {
        System.out.println(message);
    }

    void printSeparator() {
        println(separator);
    }

    void printError(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}

class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    public InputHandler(Printer printer) {
        this.printer = printer;
    }

    double getPositiveDoubleValue(String message) {
        while (true) {
            printer.println(message);
            String input = scanner.nextLine().trim().replace(",", ".");

            if (input.isEmpty()) {
                printer.printError("Błąd: Pole nie może być puste.");
                continue;
            }

            try {
                double value = Double.parseDouble(input);
                if (value >= 0) return value;
                printer.printError("Błąd: Kwota nie może być ujemna.");
            } catch (NumberFormatException e) {
                printer.printError("Błąd: '" + input + "' nie jest poprawną liczbą.");
            }
        }
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
