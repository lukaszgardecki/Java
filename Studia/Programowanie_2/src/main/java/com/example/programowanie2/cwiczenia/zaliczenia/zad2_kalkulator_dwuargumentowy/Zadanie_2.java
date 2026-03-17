package com.example.programowanie2.cwiczenia.zaliczenia.zad2_kalkulator_dwuargumentowy;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Zadanie_2 {
    public static void main(String[] args) {
        new KalkulatorDwuargumentowy().run();
    }
}

class KalkulatorDwuargumentowy {
    private final InputHandler inputHandler;
    private final Printer printer;

    KalkulatorDwuargumentowy() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        printer.printAppInfo();
        boolean shouldContinue = true;

        try(inputHandler) {
            while (shouldContinue) {
                double val1 = inputHandler.getDoubleValue("Podaj pierwszą liczbę:");
                MathOperation operation = inputHandler.getOperator();
                double val2 = inputHandler.getDoubleValue("Podaj drugą liczbę:");
                calculate(val1, val2, operation).ifPresent(printer::print);
                shouldContinue = inputHandler.getContinueAnswer("Czy chcesz wykonać kolejne obliczenie? (t/n): ");
            }
        }
        printer.println("Koniec programu.");
    }

    private Optional<Result> calculate(double val1, double val2, MathOperation operation) {
        try {
            return Optional.of(operation.calculate(val1, val2));
        } catch (ArithmeticException e) {
            printer.printError(e.getMessage());
        }
        return Optional.empty();
    }
}

record Result(
        Double value,
        Double num1,
        Double num2,
        MathOperation operation
) { }

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

    MathOperation getOperator() {
        while (true) {
            printer.println("Podaj operator (+, -, *, /): ");
            String input = scanner.nextLine().trim();

            MathOperation operation = MathOperation.fromSign(input);

            if (operation != null) {
                return operation;
            }
            printer.printError("Błąd: Nieprawidłowy operator! Użyj +, -, * lub /");
        }
    }

    boolean getContinueAnswer(String prompt) {
        printer.printSeparator();
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
        println("Kalkulator dwuargumentowy");
        String units = Arrays.stream(MathOperation.values())
                .map(MathOperation::toString)
                .collect(Collectors.joining(", "));
        println(units);
        printSeparator();
    }

    void print(Result result) {
        printf("Wynik: %s %s %s = %s\n", result.num1(), result.operation().getSign(), result.num2(), result.value());
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

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}

enum MathOperation {
    ADD("+", "dodawanie", (v1, v2) -> v1 + v2),
    SUBTRACT("-", "odejmowanie", (v1, v2) -> v1 - v2),
    MULTIPLY("*", "mnożenie", (v1, v2) -> v1 * v2),
    DIVIDE("/", "dzielenie", (v1, v2) -> {
        if (v2 == 0) throw new ArithmeticException("Dzielenie przez zero!");
        return v1 / v2;
    });

    private final String sign;
    private final String opName;
    private final BinaryOperator<Double> operation;

    MathOperation(String sign, String opName, BinaryOperator<Double> operation) {
        this.sign = sign;
        this.opName = opName;
        this.operation = operation;
    }

    String getSign() {
        return sign;
    }

    public static MathOperation fromSign(String input) {
        for (MathOperation op : values()) {
            if (op.sign.equals(input)) return op;
        }
        return null;
    }

    public Result calculate(double v1, double v2) {
        double result = operation.apply(v1, v2);
        return new Result(result, v1, v2, this);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", sign, opName);
    }
}