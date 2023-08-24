package budget;

import java.util.List;

public class Sorter {

    public void doBubbleSort(List<Product> list) {
        for (int i = 0; i < list.size() - 1; i++ ) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                double price1 = list.get(j).getPrice();
                double price2 = list.get(j+1).getPrice();

                //TO SORT IN ASCENDING ORDER, CHANGE < TO >
                if (price1 < price2) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
