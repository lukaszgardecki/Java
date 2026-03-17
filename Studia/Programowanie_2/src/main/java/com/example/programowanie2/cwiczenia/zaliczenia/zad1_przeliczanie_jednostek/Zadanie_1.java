package com.example.programowanie2.cwiczenia.zaliczenia.zad1_przeliczanie_jednostek;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Zadanie_1 {
    public static void main(String[] args) {
        new PrzeliczanieJednostek().run();
    }
}

class PrzeliczanieJednostek {
    private final InputHandler inputHandler;
    private final Printer printer;

    PrzeliczanieJednostek() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
    }

    void run() {
        Optional<Double> input;
        printer.printAppInfo();
        try(inputHandler) {
            do {
                input = inputHandler.getPositiveDoubleValue("Podaj odległość w metrach lub wciśnij Q żeby wyjść: ");
                input.ifPresent(val -> printer.print(new Results(val)));
            } while (input.isPresent());
        }
        printer.println("Koniec programu.");
    }
}

class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;
    private final Predicate<Double> validator = value -> value >= 0;

    InputHandler(Printer printer) {
        this.printer = printer;
    }

    Optional<Double> getPositiveDoubleValue(String promptMsg) {
        Optional<Double> output = Optional.empty();
        do {
            printer.println(promptMsg);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) break;

            try {
                double value = Double.parseDouble(input);

                if (validator.test(value)) {
                    output = Optional.of(value);
                } else {
                    printer.printError("Liczba ujemna - proszę podać liczbę nieujemną.");
                }
            } catch (NumberFormatException e) {
                printer.printError("Błąd: Proszę wprowadzić poprawną liczbę.");
            }
        } while (output.isEmpty());
        return output;
    }

    @Override
    public void close() {
        scanner.close();
    }
}

class Printer {
    private final String separator = "-".repeat(98);

    void printAppInfo() {
        println(separator);
        println("Program przelicza odległość podaną w metrach na:");
        String units = Arrays.stream(Unit.values())
                .map(Unit::getDisplayName)
                .collect(Collectors.joining(", "));
        println(units);
        println(separator);
    }

    void print(Results results) {
        printf("Wyniki dla wartości %sm (zaokrąglone do 4 miejsc):\n", results.getValueInMeters());
        results.getValues().forEach((key, value) -> printf("- %s: %.4f\n", key.getDisplayName(), value));
        println(separator);
    }

    void println(String message) {
        System.out.println(message);
    }

    void printError(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}

enum Unit {
    INCHES_PER_METER("cale", 39.37007874),
    FEET_PER_METER("stopy",  3.2808399),
    YARDS_PER_METER("jardy", 1.0936133),
    LAND_MILES_PER_METER("mile lądowe", 0.0006213711922373),
    FATHOMS_PER_METER("sążnie",  0.5468066491688539),
    NAUTICAL_MILES_PER_METER("mile morskie", 0.0005399568034557),
    ANGSTROMS_PER_METER("angstremy", 10000000000.0),
    CABLES_PER_METER("kable", 0.0053995680345572),
    GDANSK_ELLS_PER_METER("łokcie gdańskie", 0.578),
    VERSTS_PER_METER("wiorsty", 1066.78);

    private final String name;
    private final double factor;

    Unit(String name, double factor) {
        this.name = name;
        this.factor = factor;
    }

    String getDisplayName() {
        return this.name;
    }

    double getFactor() {
        return this.factor;
    }
}

class Results {
    private final double valInMeters;
    private final Map<Unit, Double> values;

    Results(double valInMeters) {
        this.valInMeters = valInMeters;
        this.values = new EnumMap<>(Unit.class);

        for (Unit u : Unit.values()) {
            this.values.put(u, valInMeters * u.getFactor());
        }
    }

    double getValueInMeters() {
        return this.valInMeters;
    }

    Map<Unit, Double> getValues() {
        return this.values;
    }
}