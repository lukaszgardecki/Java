package com.example.templatemethod;

public class MeatFeastPizza extends Pizza {

    @Override
    public void addToppings() {
        System.out.println("Add pepperoni, ham and chicken" );
    }
}
