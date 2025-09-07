package com.example.iterator;

import java.util.Iterator;

public class StockIterator  implements Iterator {
    private final Inventory inventory;
    private int index;

    public StockIterator(Inventory inventory) {
        this.inventory = inventory;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        var items = inventory.getItems();
        return index < items.length;
    }

    @Override
    public Object next() {
        var items = inventory.getItems();
        if (hasNext()) {
            var item = items[index++];
            if (item.getQuantity() > 0) {
                return item;
            } else {
                return next();
            }
        } else {
            return null;
        }
    }
}
