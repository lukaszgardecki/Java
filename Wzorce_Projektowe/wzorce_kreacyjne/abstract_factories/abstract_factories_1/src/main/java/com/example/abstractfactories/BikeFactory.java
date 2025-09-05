package com.example.abstractfactories;

public interface BikeFactory {

    Handlebars createHandleBars();
    Pedals createPedals();
    Tire createTire();
}
