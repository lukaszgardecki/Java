package com.example.planner;

class Building {
    private int width;
    private int height;
    private boolean road;

    Building(int width, int height, boolean road) {
        this.width = width;
        this.height = height;
        this.road = road;
    }

    int getWidth() {
        return width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    boolean isRoad() {
        return road;
    }

    void setRoad(boolean road) {
        this.road = road;
    }
}
