package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status) {
        System.out.println("Checkout Method from ShoppingCart calling");
    }

    public int quantity(int value) {
        return value;
    }
}
