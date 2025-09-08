package com.example.mediator;

public class App {

    public static void main(String[] args) {
        var trafficLight = new TrafficLight();
        var pedestrianCrossingLight = new PedestrianCrossingLight();
        Mediator mediator = new Mediator(trafficLight, pedestrianCrossingLight);

        mediator.changeTrafficLightToAmber();
        mediator.changeTrafficLightToGreen();
        mediator.changeTrafficLightToAmber();
        mediator.changeTrafficLightToRed();
    }
}
