package com.example.programowanie2.cwiczenia.zaliczenia.zad13_figury;

interface Figura {
    double pole();
    double obwod();
}


class Kolo implements Figura {
    private final double r;

    Kolo() {
        this(10.0);
    }

    Kolo(double r) {
        this.r = r;
    }

    @Override
    public double pole() {
        return Math.PI * r * r;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * r;
    }
}


class Kwadrat implements Figura {
    private final double a;

    Kwadrat() {
        this(10.0);
    }

    Kwadrat(double a) {
        this.a = a;
    }

    @Override
    public double pole() {
        return a * a;
    }

    @Override
    public double obwod() {
        return 4 * a;
    }
}


class Prostokat implements Figura {
    private final double a;
    private final double b;

    Prostokat() {
        this(10.0, 15.0);
    }

    Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole() {
        return a * b;
    }

    @Override
    public double obwod() {
        return 2 * (a + b);
    }
}


class Trapez implements Figura {
    private final double a;
    private final double b;
    private final double h;

    Trapez() {
        this(10.0, 15.0, 12.0);
    }

    Trapez(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double pole() {
        return (a + b) * h / 2;
    }

    @Override
    public double obwod() {
        double x = Math.abs(a - b) / 2.0;
        double bokC = Math.sqrt(x*x + h*h);
        return a + b + (2 * bokC);
    }
}