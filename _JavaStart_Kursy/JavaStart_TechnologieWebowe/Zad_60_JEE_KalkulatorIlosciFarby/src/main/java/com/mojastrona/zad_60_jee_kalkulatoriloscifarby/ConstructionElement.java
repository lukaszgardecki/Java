package com.mojastrona.zad_60_jee_kalkulatoriloscifarby;

public class ConstructionElement {
    private int width;
    private int height;

    public ConstructionElement(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getArea() {
        return width * height;
    }
}
