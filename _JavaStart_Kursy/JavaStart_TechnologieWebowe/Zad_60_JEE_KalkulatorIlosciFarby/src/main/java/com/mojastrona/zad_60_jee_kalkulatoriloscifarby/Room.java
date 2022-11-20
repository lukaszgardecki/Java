package com.mojastrona.zad_60_jee_kalkulatoriloscifarby;

import java.util.Arrays;

public class Room {
    private int width;
    private int height;
    private int length;
    private ConstructionElement[] constructionElements;

    public Room(int width, int height, int length, ConstructionElement[] constructionElements) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.constructionElements = constructionElements;
    }

    int getWallArea() {
        return 2 * (width * height + length * height);
    }

    int getConstructionElementsArea() {
        return Arrays.stream(constructionElements)
                .mapToInt(ConstructionElement::getArea)
                .sum();
    }

    int getPaintArea() {
        int wallArea = getWallArea();
        int cutArea = getConstructionElementsArea();
        return wallArea - cutArea;
    }
}
