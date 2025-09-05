package com.example.abstractfactories;

public class MountainBikeHandlebars implements Handlebars {

    @Override
    public String getType() {
        return "FLAT";
    }
}
