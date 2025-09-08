package com.example.observer;

public class App {

    public static void main(String[] args) {
        var location1 = new Location();
        var location2 = new Location();
        var weatherUpdates = new WeatherUpdates();

        location1.addPropertyListener(weatherUpdates);
        location2.addPropertyListener(weatherUpdates);

        location1.setWeatherEvent("Risk of flooding");
        location2.setWeatherEvent("Risk of drought");

        weatherUpdates.printUpdates();
    }

}
