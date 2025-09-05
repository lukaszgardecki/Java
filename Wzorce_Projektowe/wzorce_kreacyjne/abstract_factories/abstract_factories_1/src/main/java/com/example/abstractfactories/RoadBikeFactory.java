package com.example.abstractfactories;

public class RoadBikeFactory implements BikeFactory {

    @Override
    public Handlebars createHandleBars() {
        return new RoadBikeHandlebars();
    }

    @Override
    public Pedals createPedals() {
        return new RoadBikePedals();
    }

    @Override
    public Tire createTire() {
        return new RoadBikeTire();
    }
}
