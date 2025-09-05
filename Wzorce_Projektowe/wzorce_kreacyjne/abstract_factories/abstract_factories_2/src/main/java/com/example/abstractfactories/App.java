package com.example.abstractfactories;

public class App {

    public static void main(String[] args) {
        UserInterface roadUserInterface = createUserInterface("RED");
        UserInterface mountainUserInterface = createUserInterface("BLUE");

        System.out.println(roadUserInterface);
        System.out.println(mountainUserInterface);
    }

    private static UserInterface createUserInterface(String color) {
        var interfaceFactory = FactoryMaker.createFactory(color);
        var button = interfaceFactory.createButton();
        var scrollBar = interfaceFactory.createScrollBar();
        return new UserInterface(button, scrollBar);
    }
}
