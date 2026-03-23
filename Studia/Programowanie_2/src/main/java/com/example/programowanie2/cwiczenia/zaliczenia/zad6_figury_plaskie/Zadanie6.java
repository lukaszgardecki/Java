package com.example.programowanie2.cwiczenia.zaliczenia.zad6_figury_plaskie;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) {
        new FiguryPlaskie().run();
    }
}


class FiguryPlaskie {
    private final ShapeService shapeService;
    private final InputHandler inputHandler;
    private final Printer printer;

    FiguryPlaskie() {
        this.printer = new Printer();
        this.inputHandler = new InputHandler(printer);
        this.shapeService = new ShapeService(inputHandler, printer);
    }

    void run() {
        printer.printAppInfo();

        try (inputHandler) {
            while (true) {
                printer.printMenu();
                int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

                if (choice == MenuOption.EXIT.getId()) break;

                MenuOption.fromInt(choice).ifPresentOrElse(
                        shapeService::handleCalculation,
                        () -> printer.printError("Nie ma takiej opcji!")
                );
            };
        }
        printer.println("Koniec programu.");
    }
}


enum MenuOption {
    SQUARE(1, "Kwadrat"),
    RECTANGLE(2, "Prostokąt"),
    CIRCLE(3, "Koło"),
    TRIANGLE(4, "Trójkąt"),
    TRAPEZOID(5, "Trapez równoramienny"),
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


enum SubmenuOption {
    AREA(1, "Oblicz pole"),
    PERIMETER(2, "Oblicz obwód"),
    BACK(0, "Wróć");

    private final int id;
    private final String name;

    SubmenuOption(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() { return id; }

    static Optional<SubmenuOption> fromInt(int id) {
        for (SubmenuOption o : values()) {
            if (o.id == id) return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }
}


class ShapeService {
    private final InputHandler inputHandler;
    private final Printer printer;

    ShapeService(InputHandler inputHandler, Printer printer) {
        this.inputHandler = inputHandler;
        this.printer = printer;
    }

    void handleCalculation(MenuOption option) {
        printer.printf("Wybrano: %s%n", option.getName());
        while (true) {
            printer.printSubmenu();
            int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

            if (choice == SubmenuOption.BACK.getId()) return;

            Optional<SubmenuOption> subOptionOpt = SubmenuOption.fromInt(choice);

            if (subOptionOpt.isPresent()) {
                Shape shape = createShapeFromOption(option);
                printer.print(new Result(shape, subOptionOpt.get()));
                return;
            }
            printer.printError("Nie ma takiej opcji!");
        }
    }

    private Shape createShapeFromOption(MenuOption option) {
        return switch (option) {
            case SQUARE -> createSquare();
            case RECTANGLE -> createRectangle();
            case CIRCLE -> createCircle();
            case TRIANGLE -> createTriangle();
            case TRAPEZOID -> createTrapezoid();
            default -> throw new IllegalArgumentException("Niezidentyfikowano: " + option);
        };
    }

    private Square createSquare() {
        double a = inputHandler.getPositiveDoubleValue("Wpisz długość boku a:");
        return new Square(a);
    }

    private Rectangle createRectangle() {
        double a = inputHandler.getPositiveDoubleValue("Wpisz długość boku a:");
        double b = inputHandler.getPositiveDoubleValue("Wpisz długość boku b:");
        return new Rectangle(a, b);
    }

    private Circle createCircle() {
        double r = inputHandler.getPositiveDoubleValue("Wpisz długość promienia r:");
        return new Circle(r);
    }

    private Triangle createTriangle() {
        double a = inputHandler.getPositiveDoubleValue("Wpisz długość podstawy a:");
        double h = inputHandler.getPositiveDoubleValue("Wpisz wysokość h:");
        return new Triangle(a, h);
    }

    private Trapezoid createTrapezoid() {
        double a = inputHandler.getPositiveDoubleValue("Wpisz długość podstawy a:");
        double b = inputHandler.getPositiveDoubleValue("Wpisz długość podstawy b:");
        double h = inputHandler.getPositiveDoubleValue("Wpisz wysokość h:");
        return new Trapezoid(a, b, h);
    }
}


class Result {
    private final Shape shape;
    private final String label;
    private final double value;

    Result(Shape shape, SubmenuOption submenuOption) {
        this.shape = shape;
        this.label = submenuOption == SubmenuOption.AREA ? "Pole" : "Obwód";
        this.value = submenuOption == SubmenuOption.AREA ? shape.calculateArea() : shape.calculatePerimeter();
    }

    @Override
    public String toString() {
        return String.format("%s figury (%s) to %.4f", label, shape.getName(), value);
    }
}


abstract class Shape {
    private final String name;

    Shape(String name) {
        this.name = name;
    }

    abstract double calculateArea();
    abstract double calculatePerimeter();

    String getName() { return name; }
}


class Square extends Shape {
    private final double a;

    Square(double a) {
        super("kwadrat");
        this.a = a;
    }

    @Override
    double calculateArea() {
        return a * a;
    }

    @Override
    double calculatePerimeter() {
        return 4 * a;
    }
}


class Rectangle extends Shape {
    private final double a;
    private final double b;

    Rectangle(double a, double b) {
        super("prostokąt");
        this.a = a;
        this.b = b;
    }

    @Override
    double calculateArea() {
        return a * b;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (a + b);
    }
}


class Circle extends Shape {
    private final double r;

    Circle(double r) {
        super("koło");
        this.r = r;
    }

    @Override
    double calculateArea() {
        return Math.PI * r * r;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * r;
    }
}


class Triangle extends Shape {
    private final double a;
    private final double h;

    Triangle(double a, double h) {
        super("trójkąt");
        this.a = a;
        this.h = h;
    }

    @Override
    double calculateArea() {
        return a * h/2;
    }

    @Override
    double calculatePerimeter() {
        double przeciwprostokatna = Math.sqrt(a*a + h*h);
        return a + h + przeciwprostokatna;
    }
}


class Trapezoid extends Shape {
    private final double a;
    private final double b;
    private final double h;

    Trapezoid(double a, double b, double h) {
        super("trapez równoramienny");
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    double calculateArea() {
        return (a + b) * h / 2;
    }

    @Override
    double calculatePerimeter() {
        double x = Math.abs(a - b) / 2.0;
        double bokC = Math.sqrt(x*x + h*h);
        return a + b + (2 * bokC);
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
                printer.printError("Błąd: Wartość nie może być ujemna.");
            } catch (NumberFormatException e) {
                printer.printError("Błąd: '" + input + "' nie jest poprawną liczbą.");
            }
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}


class Printer {
    private final String separator = "-".repeat(59);

    void printAppInfo() {
        printSeparator();
        println("Program obliczający pola i obwody wybranych figur płaskich:\nkwadratu, prostokąta, koła, trójkąta, trapezu.");
        printSeparator();
    }

    void printMenu() {
        Arrays.stream(MenuOption.values()).forEach(System.out::println);
        printSeparator();
    }

    void printSubmenu() {
        Arrays.stream(SubmenuOption.values()).forEach(System.out::println);
        printSeparator();
    }

    void print(Result result) {
        println(result.toString());
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