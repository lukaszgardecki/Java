package Zad_46_Ksztalty.controller;

import Zad_46_Ksztalty.io.Reader;
import Zad_46_Ksztalty.model.Circle;
import Zad_46_Ksztalty.model.Rectangle;
import Zad_46_Ksztalty.model.Triangle;

public class ShapeController {
    Reader reader = new Reader();

    public void run() {
        reader.printLine("-_-_-_- Kalkulator kszta³tów -_-_-_-");
        reader.printLine("Wybierz kszta³t:");
        reader.printLine("1 - Prostok¹t");
        reader.printLine("2 - Trójk¹t");
        reader.printLine("3 - Ko³o");

        int option = reader.getOption();
        doOperation(option);
    }

    private void doOperation(int option) {
        switch (option) {
            case 1 -> calculateRect();
            case 2 -> calculateTriangle();
            case 3 -> calculateCircle();
        }
    }


    private void calculateCircle() {
        Circle circle = reader.readCircleData();
        reader.printLine(circle.toString());
    }

    private void calculateTriangle() {
        Triangle triangle = reader.readTriangleData();
        reader.printLine(triangle.toString());
    }

    private void calculateRect() {
        Rectangle rectangle = reader.readRectangleData();
        reader.printLine(rectangle.toString());
    }
}
