package Zad_16_Punkt.controller;

import Zad_16_Punkt.model.Point;

public class PointController {

    public void addX(Point point) {
        point.setX(point.getX() + 1);
    }

    public void minusX(Point point) {
        point.setX(point.getX() - 1);
    }

    public void addY(Point point) {
        point.setY(point.getY() + 1);
    }

    public void minusY(Point point) {
        point.setY(point.getY() - 1);
    }


}
