package com.example.command;

public class RemoveFromBasketOperation implements ItemOperation {
    private final Item item;

    public RemoveFromBasketOperation(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        item.removeFromBasket();
    }
}
