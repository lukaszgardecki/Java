package com.example.abstractfactories;

public class MountainBikeFactory implements BikeFactory {

    @Override
    public Handlebars createHandleBars() {
        return new MountainBikeHandlebars();
    }

    @Override
    public Pedals createPedals() {
        return new MountainBikePedals();
    }

    @Override
    public Tire createTire() {
        return new MountainBikeTire();
    }
}
