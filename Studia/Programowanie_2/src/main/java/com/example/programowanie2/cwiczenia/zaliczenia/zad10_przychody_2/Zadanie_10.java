package com.example.programowanie2.cwiczenia.zaliczenia.zad10_przychody_2;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zadanie_10 {
    public static void main(String[] args) {
        new RocznePrzychody_v2().run();
    }
}


class RocznePrzychody_v2 {
    private final IncomeService incomeService;
    private final InputHandler inputHandler;
    private final Printer printer;

    RocznePrzychody_v2() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
        this.incomeService = new IncomeService(inputHandler, printer);
    }

    void run() {
        printer.printAppInfo();

        try(inputHandler) {
            while (true) {
                printer.printMenu();
                int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

                if (choice == MenuOption.WYJSCIE.getId()) break;

                MenuOption.fromInt(choice).ifPresentOrElse(
                        incomeService::handleMenuOption,
                        () -> printer.printError("Nie ma takiej opcji!")
                );
                printer.printSeparator();
            }
        }
        printer.println("Koniec programu.");
    }
}


enum MenuOption {
    WCZYTAJ_DOCHODY(1, "Wczytaj nowe dochody"),
    WYSWIETL_DOCHODY(2, "Wyświetl zapisane dochody"),
    SREDNIA_SUMA_DOCHODOW(3, "Wyświetl średnią wszystkich dochodów"),
    MAKS_MIN_DOCHOD(4, "Wyświetl minimalny i maksymalny dochód"),
    SORTUJ(5, "Wyświetl dochody posortowane rosnąco"),
    POD_NAD_SREDNIM_DOCHODEM(6, "Wyświetl dochody poniżej i powyżej średniej"),
    WYJSCIE(0, "Wyjście");

    private final int id;
    private final String name;

    MenuOption(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() { return id; }

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


class IncomeService {
    private Incomes incomes;
    private final InputHandler inputHandler;
    private final Printer printer;

    IncomeService(InputHandler inputHandler, Printer printer) {
        this.inputHandler = inputHandler;
        this.printer = printer;
    }

    void handleMenuOption(MenuOption option) {
        try {
            switch (option) {
                case WCZYTAJ_DOCHODY -> wczytajDochody();
                case WYSWIETL_DOCHODY -> wyswietlDochody();
                case SREDNIA_SUMA_DOCHODOW -> sredniaSumaDochodow();
                case MAKS_MIN_DOCHOD -> maksMinDochod();
                case SORTUJ -> sortuj();
                case POD_NAD_SREDNIM_DOCHODEM -> podNadSrednimDochodem();
                case WYJSCIE -> {}
            }
        } catch (NullPointerException e) {
            printer.printError("Nie wprowadzono dochodów. Najpierw wprowadź dochody.");
        }
    }

    private void wczytajDochody() {
        MonthsCount monthsCount = setupMonthsCount();
        incomes = new Incomes(monthsCount.value());
        for (int i = 0; i < monthsCount.value(); i++) {
            double income = inputHandler.getPositiveDoubleValue("Podaj przychód " + (i+1) + ": ");
            incomes.insert(income, i);
        }
    }

    private void wyswietlDochody() {
        printer.println("Wprowadzone dochody:");
        printer.print(incomes.get());
    }

    private void sredniaSumaDochodow() {
        printer.println("Dochód średni: %.2fzł".formatted(incomes.average()));
    }

    private void maksMinDochod() {
        printer.println("""
                Dochód minimalny: %.2fzł
                Dochód maksymalny: %.2fzł"""
                .formatted(incomes.min(), incomes.max())
        );
    }

    private void sortuj() {
        printer.println("Dochody posortowane rosnąco:");
        printer.print(incomes.sortedAsc());
    }

    private void podNadSrednimDochodem() {
        double average = incomes.average();
        printer.println("Dochody powyżej średniego dochodu (%.2fzł)".formatted(average));
        printer.print(incomes.aboveAverage());
        printer.println("Dochody poniżej średniego dochodu (%.2fzł)".formatted(average));
        printer.print(incomes.belowAverage());
    }

    private MonthsCount setupMonthsCount() {
        MonthsCount monthsCount = new MonthsCount();
        printer.printf("Aktualny zakres wynosi %d miesięcy.\n", monthsCount.value());

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
    private final double[] valuesPerMonth;

    Incomes(int monthCount) {
        valuesPerMonth = new double[monthCount];
    }

    void insert(double value, int i) {
        valuesPerMonth[i] = value;
    }

    double[] get() {
        return valuesPerMonth;
    }

    double average() {
        return Arrays.stream(valuesPerMonth).sum() / valuesPerMonth.length;
    }

    double min() {
        return Arrays.stream(valuesPerMonth).min().orElse(Double.MAX_VALUE);
    }

    double max() {
        return Arrays.stream(valuesPerMonth).max().orElse(-Double.MAX_VALUE);
    }

    double[] sortedAsc() {
        return Arrays.stream(valuesPerMonth).sorted().toArray();
    }

    double[] aboveAverage() {
        double average = average();
        return Arrays.stream(valuesPerMonth)
                .filter(value -> value > average)
                .toArray();
    }

    double[] belowAverage() {
        double average = average();
        return Arrays.stream(valuesPerMonth)
                .filter(value -> value < average)
                .toArray();
    }
}


class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    InputHandler(Printer printer) {
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


class Printer {
    private final String separator = "-".repeat(69);

    void printAppInfo() {
        printSeparator();
        println("Przychody roczne v2.0");
        printSeparator();
    }

    void printMenu() {
        Arrays.stream(MenuOption.values()).forEach(el -> println(el.toString()));
        printSeparator();
    }

    void print(double[] values) {
        println(IntStream.range(0, values.length)
                .mapToObj(i -> "Dochód %d: %.2fzł".formatted(i+1, values[i]))
                .collect(Collectors.joining("\n"))
        );
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

    void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}