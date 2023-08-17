package wzorce.adapter;

import wzorce.adapter.objects1.Item;

import java.util.ArrayList;
import java.util.List;

public class SwiggyStore {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
}
