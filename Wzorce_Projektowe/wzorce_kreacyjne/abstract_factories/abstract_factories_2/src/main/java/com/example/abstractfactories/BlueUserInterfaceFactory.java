package com.example.abstractfactories;

public class BlueUserInterfaceFactory implements UserInterfaceFactory {

    @Override
    public Button createButton() {
        return new BlueButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new BlueScrollBar();
    }
}
