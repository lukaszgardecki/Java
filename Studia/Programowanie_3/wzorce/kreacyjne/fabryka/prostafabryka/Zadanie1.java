package wzorce.kreacyjne.fabryka.prostafabryka;

/**
 * Zadanie 1: kalkulator pola figur
 *
 * Cel: ćwiczenie podstawowego mechanizmu fabryki i polimorfizmu
 *
 * - Zaimplementuj prostą fabrykę ShapeFactory, któa na podstawie parametru ("circle", "square", "triangle") zwraca odpowiedni obiekt implementujący interfejs Shape
 * - Rozszerzenie: Dodaj nowe figury (np. rectangle, trapeze) i pokaż, jak favryka musi zostać zmodyfikowana
 */
public class Zadanie1 {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.createShape(ShapeType.CIRCLE, 5);
        Shape s2 = ShapeFactory.createShape(ShapeType.SQUARE, 4);
        Shape s3 = ShapeFactory.createShape(ShapeType.TRIANGLE, 3, 6);
        Shape s4 = ShapeFactory.createShape(ShapeType.RECTANGLE, 2, 4);
        Shape s5 = ShapeFactory.createShape(ShapeType.TRAPEZE, 3, 5, 6);

        System.out.println("Pole koła: " + s1.area());
        System.out.println("Pole kwadratu: " + s2.area());
        System.out.println("Pole trójkąta: " + s3.area());
        System.out.println("Pole prostokąta: " + s4.area());
        System.out.println("Pole trapezu: " + s5.area());
    }
}

enum ShapeType {
    CIRCLE, SQUARE, TRIANGLE, RECTANGLE, TRAPEZE;
}

class ShapeFactory {

    static Shape createShape(ShapeType type, int... args) {
        return switch (type) {
            case CIRCLE -> new Circle(args[0]);
            case SQUARE -> new Square(args[0]);
            case TRIANGLE -> new Triangle(args[0], args[1]);
            case RECTANGLE -> new Rectangle(args[0], args[1]);
            case TRAPEZE -> new Trapeze(args[0], args[1], args[2]);
        };
    }
}

interface Shape {
    double area();
}

class Circle implements Shape {
    private final double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }
}

class Square implements Shape {
    private final double a;

    Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return a * a;
    }
}

class Triangle implements Shape {
    private final double a;
    private final double h;

    Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public double area() {
        return a * h / 2;
    }
}

class Rectangle implements Shape {
    private final double a;
    private final double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }
}

class Trapeze implements Shape {
    private final double a;
    private final double b;
    private final double h;

    Trapeze(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double area() {
        return (a + b) * h / 2;
    }
}
