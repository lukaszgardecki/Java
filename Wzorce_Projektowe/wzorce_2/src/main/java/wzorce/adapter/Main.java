package wzorce.adapter;

import wzorce.adapter.objects1.FoodItem;
import wzorce.adapter.objects2.GroceryItemAdapter;
import wzorce.adapter.objects2.GroceryProduct;

public class Main {
    public static void main(String[] args) {

        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItem(new FoodItem());
        swiggyStore.addItem(new FoodItem());
//        swiggyStore.addItem(new GroceryProduct()); // nie możemy tak zrobić bo produkt ten nie pasuje
        //opakowujemy GroceryProduct
        //adapter musi implementować interfejs DOCELOWY
        swiggyStore.addItem(new GroceryItemAdapter(new GroceryProduct()));
    }
}
