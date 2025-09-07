package com.example.command;

public class TurnOffTheLightCommand implements LightCommand {
    private final Light light;

    public TurnOffTheLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOffLight();
    }
}
