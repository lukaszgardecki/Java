package com.example.abstractfactories;

public class BikeManufacturer {

    public static void main(String[] args) {
        Bike roadBike = buildBike("ROAD");
        Bike mountainBike = buildBike("MOUNTAIN");

        System.out.println(roadBike);
        System.out.println(mountainBike);
    }

    private static Bike buildBike(String bikeType) {
        var bikeFactory = FactoryMaker.createFactory(bikeType);
        Handlebars handleBars = bikeFactory.createHandleBars();
        Pedals pedals = bikeFactory.createPedals();
        Tire frontTire = bikeFactory.createTire();
        Tire backTire = bikeFactory.createTire();
        return new Bike(handleBars, pedals, frontTire, backTire);
    }
}
