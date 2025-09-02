import java.util.Iterator;

public class StockIterator implements Iterator {
    private final Inventory inventory;
    private int index;

    public StockIterator(Inventory inventory) {
        this.inventory = inventory;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        Item[] items = inventory.getItems();
        return index < items.length;
    }

    @Override
    public Item next() {
        Item[] items = inventory.getItems();
        if (hasNext()) {
            Item item = items[index++];
            if (item.getQuantity() > 0) {
                return item;
            } else {
                return next();
            }
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
