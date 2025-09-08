package com.example.mediator;

public class Mediator {
    private final TrafficLight trafficLight;
    private final PedestrianCrossingLight pedestrianCrossingLight;

    public Mediator(TrafficLight trafficLight, PedestrianCrossingLight pedestrianCrossingLight) {
        this.trafficLight = trafficLight;
        this.pedestrianCrossingLight = pedestrianCrossingLight;
    }

    public void changeTrafficLightToRed() {
        trafficLight.changeToRed();
        pedestrianCrossingLight.changeToGreen();
    }

    public void changeTrafficLightToAmber() {
        trafficLight.changeToAmber();
    }

    public void changeTrafficLightToGreen() {
        pedestrianCrossingLight.changeToRed();
        trafficLight.changeToGreen();
    }
}
