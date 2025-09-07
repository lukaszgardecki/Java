package com.example.command;

import java.util.ArrayList;
import java.util.List;

public class LightOperator {

    public void execute(LightCommand lightCommand) {
        lightCommand.execute();
    }
}
