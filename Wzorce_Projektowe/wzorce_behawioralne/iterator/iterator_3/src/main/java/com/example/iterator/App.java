package com.example.iterator;

public class App {

    public static void main(String[] args) {

        var pen = new Item("Pen", 20);
        var pencil = new Item("Pencil", 0);
        var eraser = new Item("Eraser", 15);

        var inventory = new Inventory(pen, pencil, eraser);

        for (Item item : inventory) {
            System.out.println(item.getName());
        }
    }

}
