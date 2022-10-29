package Zad_16_Punkt;

import Zad_16_Punkt.controller.PointController;
import Zad_16_Punkt.model.Point;

public class PointApplication {
    public static void main(String[] args) {
        Point point = new Point(2, 5);

        PointController pointController = new PointController();

        int choice = 1;

        switch (choice) {
            case 1 -> pointController.addX(point);
            case 2 -> pointController.minusX(point);
            case 3 -> pointController.addY(point);
            case 4 -> pointController.minusY(point);
        }




        System.out.println(point);
    }

}
