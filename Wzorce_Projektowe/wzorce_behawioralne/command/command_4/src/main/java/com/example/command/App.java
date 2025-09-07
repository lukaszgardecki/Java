package com.example.command;

public class App {

    public static void main(String[] args) {
        var light = new Light();

        LightOperator lightOperator = new LightOperator();
        light.isOn();
        lightOperator.execute(new TurnOnTheLightCommand(light));
        light.isOn();
        lightOperator.execute(new TurnOffTheLightCommand(light));
        light.isOn();
    }

}
