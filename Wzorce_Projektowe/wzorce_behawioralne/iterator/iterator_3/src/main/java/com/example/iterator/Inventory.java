package com.example.iterator;

import java.util.Iterator;

public class Inventory implements Iterable<Item> {
    private final Item[] items;

    public Inventory(Item... items) {
        this.items = items;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StockIterator(this);
    }

    public Item[] getItems() {
        return items;
    }
}
