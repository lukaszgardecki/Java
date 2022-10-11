package com.example.Testy_Cwiczenie5.shopingBasket;

public class Item {
    private final double UNIT_PRICE;
    private final int QUANTITY;

    public Item(double unitPrice, int quantity) {
        this.UNIT_PRICE = unitPrice;
        this.QUANTITY = quantity;
    }

    public double getUnitPrice() {
        return UNIT_PRICE;
    }

    public double getQuantity() {
        return QUANTITY;
    }

    double getSubtotal() {
        return UNIT_PRICE * QUANTITY;
    }
}
