package com.example.Testy_Cwiczenie5.TDD_3;

public class CompactDisc {

    private int stock;

    public CompactDisc(int initialStock) {
        this.stock = initialStock;
    }


    public int getStockCount() {
        return stock;
    }

    public void buy(int quantity) {
        stock -= quantity;
    }
}
