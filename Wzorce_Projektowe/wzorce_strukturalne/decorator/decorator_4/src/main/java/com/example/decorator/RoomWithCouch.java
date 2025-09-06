package com.example.decorator;

public class RoomWithCouch extends RoomDecorator {

    public RoomWithCouch(Room room) {
        super(room);
    }

    @Override
    public void printFurniture() {
        super.printFurniture();
        System.out.println("Couch");
    }
}
