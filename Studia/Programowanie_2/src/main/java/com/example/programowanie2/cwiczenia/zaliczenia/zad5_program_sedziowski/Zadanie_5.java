package com.example.programowanie2.cwiczenia.zaliczenia.zad5_program_sedziowski;

import java.util.Scanner;

public class Zadanie_5 {
    public static void main(String[] args) {
        new ProgramSedziowski().run();
    }
}

class ProgramSedziowski {
    private final InputHandler inputHandler;
    private final Printer printer;

    ProgramSedziowski() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        printer.printAppInfo();
        JudgeCount judgeCount = setupJudgeCount();
        boolean nextParticipant = true;

        try(inputHandler) {
            while (nextParticipant) {
                Result result = new Result();

                for (int i = 0; i < judgeCount.value(); i++) {
                    double score = inputHandler.getValidScore("Podaj ocenę sędziego nr " + (i+1) + " (0-10): ");
                    result.addScore(score);
                }

                printer.printSeparator();
                printer.print(result);
                printer.printSeparator();

                nextParticipant = inputHandler.getAnswer("Czy ocenić kolejnego zawodnika? (t/n): ");
            }
        }
        System.out.println("Koniec programu.");
    }

    JudgeCount setupJudgeCount() {
        JudgeCount judgeCount = new JudgeCount();
        printer.printf("Aktualna liczba sędziów: %d.\n", judgeCount.value());

        boolean changeJudgeCount = inputHandler.getAnswer("Czy chcesz zmienić liczbę sędziów? (t/n)");
        if (!changeJudgeCount) return judgeCount;

        int judges;

        while (true) {
            judges = inputHandler.getPositiveInt("Wpisz liczbę sędziów, którzy będą oceniać (3-10):");
            try {
                return new JudgeCount(judges);
            } catch (IllegalArgumentException e) {
                printer.printError("Błąd: Minimalna liczba sedziów to 3, a maksymalna to 10.");
            }
        }
    }
}

record JudgeCount(int value) {
    JudgeCount() {
        this(10);
    }

    JudgeCount {
        if (value < 3 || value > 10) throw new IllegalArgumentException();
    }
}

class Result {
    private double sum = 0;
    private int count = 0;

    private double min = Double.MAX_VALUE;
    private double max = -Double.MAX_VALUE;

    void addScore(double score) {
        sum += score;
        count++;
        if (score < min) min = score;
        if (score > max) max = score;
    }

    private double calculate() {
        if (count <= 2) return 0;
        return (sum - min - max) / (count - 2);
    }

    @Override
    public String toString() {
        return String.format("Średnia ocena zawodnika: %.2f", calculate());
    }
}

class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    public InputHandler(Printer printer) {
        this.printer = printer;
    }

    double getValidScore(String message) {
        while (true) {
            printer.println(message);
            String input = scanner.nextLine().trim().replace(",", ".");
            try {
                double value = Double.parseDouble(input);
                if (value >= 0 && value <= 10) return value;
                printer.printError("Błąd: Ocena musi mieścić się w przedziale od 0 do 10.");
            } catch (NumberFormatException e) {
                printer.printError("Błąd: '" + input + "' nie jest poprawną liczbą.");
            }
        }
    }

    int getPositiveInt(String message) {
        while (true) {
            printer.println(message);
            var input = scanner.nextLine().trim().replace(",", ".");
            try {
                int result = Integer.parseInt(input);
                if (result >=0)  return result;
                printer.printError("Błąd: Liczba nie może być ujemna.");
            } catch (NumberFormatException e) {
                printer.printError("Błąd: '" + input + "' nie jest poprawną liczbą.");
            }
        }
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
    private final String separator = "-".repeat(69);

    void printAppInfo() {
        printSeparator();
        println("Program sędziowski");
        printSeparator();
    }

    void print(Result result) {
        println(result.toString());
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