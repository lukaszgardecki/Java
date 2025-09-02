import java.util.Iterator;

public class Inventory implements Iterable {
    private final Item[] items;

    public Inventory(Item... items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public StockIterator iterator() {
        return new StockIterator(this);
    }
}
