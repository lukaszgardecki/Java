package com.example.adapter;

public class FrenchMessageAdapter extends FrenchLocalizedMessage implements LocalizedMessage {

    @Override
    public void sayHello() {
        sayBonjour();
    }
}
