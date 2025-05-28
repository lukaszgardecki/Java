package com.example.planner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FoePlanner {
    public static void main(String[] args) {
        File file = new File("map.txt");
        MapLoader loader = new MapLoader();
        MapPrinter printer = new MapPrinter();

        FoeMap map = loader.load(file);

        MapPlanner mapPlanner = new MapPlanner(map);
        Building b1 = new Building(2, 3, true);
        List<Building> buildings = new ArrayList<>(List.of(
                new Building(2, 2, true),
                new Building(2, 2, true),
                new Building(2, 2, true),
                new Building(2, 2, true),
                new Building(4, 2, true)
        ));

        printer.print(map);
        System.out.println("---------");
//        mapPlanner.add(b1);
        mapPlanner.addAll(buildings);
        printer.print(map);

    }
}
