package com.example.command;

public class TurnOnTheLightCommand implements LightCommand {
    private final Light light;

    public TurnOnTheLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOnLight();
    }
}
