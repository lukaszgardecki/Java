package com.example.memento;

public class ItemState {
    private int state;

    public ItemState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
