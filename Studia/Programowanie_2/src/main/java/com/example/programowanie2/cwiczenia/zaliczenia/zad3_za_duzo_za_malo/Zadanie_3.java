package com.example.programowanie2.cwiczenia.zaliczenia.zad3_za_duzo_za_malo;

import java.util.Random;
import java.util.Scanner;

public class Zadanie_3 {
    public static void main(String[] args) {
        new GraZaDuzoZaMalo().run();
    }
}

class GraZaDuzoZaMalo {
    private final GameController gameController;
    private final InputHandler inputHandler;
    private final Printer printer;

    GraZaDuzoZaMalo() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
        this.gameController = new GameController(inputHandler, printer);
    }

    public void run() {
        printer.printAppInfo();
        boolean shouldContinue = true;

        try(inputHandler) {
            while (shouldContinue) {
                gameController.takeTurn();
                printer.printSeparator();
                shouldContinue = inputHandler.getAnswer("Gramy jeszcze raz? (t/n): ");
            }
        }

        printer.println("Koniec gry.");
    }
}

class GameController {
    private static final int INITIAL_TRIES = 7;
    private final InputHandler inputHandler;
    private final NumberGenerator generator;
    private final Printer printer;
    private int triesLeft = INITIAL_TRIES;

    GameController(InputHandler inputHandler, Printer printer) {
        this.inputHandler = inputHandler;
        this.printer = printer;
        this.generator = new NumberGenerator();
    }

    void takeTurn() {
        triesLeft = INITIAL_TRIES;
        var range = setupRange();
        int answer = generator.generateInt(range);
        boolean won = playGuessingLoop(answer);

        if(!won) {
            printer.printf("Tym razem się nie udało :( Poprawna odpowiedź to %d.\n", answer);
        }
    }

    private boolean playGuessingLoop(int answer) {
        while (triesLeft > 0) {
            int guess = inputHandler.getIntegerValue("Podaj liczbę (pozostałe próby: " + triesLeft + "):");
            triesLeft--;
            if (guess == answer) {
                printer.printf("Brawo, to ta liczba! Wykorzystane próby: %d\n",  INITIAL_TRIES-triesLeft);
                return true;
            }
            printer.println(guess > answer ? "Za dużo." : "Za mało.");
        }
        return false;
    }

    private GuessRange setupRange() {
        GuessRange guessRange = new GuessRange();
        printer.printf("Aktualny zakres losowanych liczb: [%d, %d]\n", guessRange.min(), guessRange.max());

        boolean selectRange = inputHandler.getAnswer("Czy chcesz zmienić ten zakres? (t/n)");
        if (!selectRange) return guessRange;

        int min = inputHandler.getIntegerValue("Podaj dolny zakres losowanych liczb:");
        int max;

        while (true) {
            max = inputHandler.getIntegerValue("Podaj górny zakres losowanych liczb:");
            try {
                return new GuessRange(min, max);
            } catch (IllegalArgumentException e) {
                printer.printError("Błąd: Górny zakres (" + max + ") nie może być mniejszy niż dolny (" + min + ")!");
            }
        }
    }
}

record GuessRange(int min, int max) {
    GuessRange() {
        this(-200, 200);
    }

    GuessRange {
        if (max < min) throw new IllegalArgumentException();
    }
}

class NumberGenerator {
    private final Random random = new Random();

    int generateInt(GuessRange range) {
        return random.nextInt(range.max() + 1 - range.min()) + range.min();
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
            try {
                var input = scanner.nextLine().trim().replace(",", ".");
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

class Printer {
    private final String separator = "-".repeat(69);

    void printAppInfo() {
        printSeparator();
        println("Gra \"Za dużo Za mało\"");
        printSeparator();
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