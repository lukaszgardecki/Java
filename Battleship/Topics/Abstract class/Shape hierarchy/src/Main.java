abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getPerimeter() {
        return a + b + c;
    }
    double getArea() {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle (double a, double b) {
        this.a = a;
        this.b = b;
    }

    double getPerimeter() {
        return 2 * (a + b);
    }
    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    private double r;

    public Circle (double r) {
        this.r = r;
    }

    double getPerimeter() {
        return 2 * Math.PI * r;
    }
    double getArea() {
        return Math.PI * r * r;
    }
}