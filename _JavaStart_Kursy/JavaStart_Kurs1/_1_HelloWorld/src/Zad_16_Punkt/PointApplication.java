package Zad_16_Punkt;

import Zad_16_Punkt.controller.PointController;
import Zad_16_Punkt.model.Point;

public class PointApplication {
    public static void main(String[] args) {
        Point point = new Point(2, 5);

        PointController pointController = new PointController();
        pointController.addX(point);
        pointController.addX(point);
        pointController.addX(point);
        pointController.addX(point);

        pointController.minusX(point);
        pointController.minusX(point);

        pointController.addY(point);
        pointController.addY(point);
        pointController.addY(point);

        pointController.minusY(point);

        System.out.println(point);
    }

}
