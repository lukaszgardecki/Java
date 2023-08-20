package budget;

import java.util.ArrayList;

public class Sorter {

    public void doBubbleSort(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++ ) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                String el1 = list.get(j);
                String el2 = list.get(j+1);
                String p1 = el1.substring(el1.lastIndexOf("$") + 1);
                String p2 = el2.substring(el2.lastIndexOf("$") + 1);

                if (p1.contains(",")) p1 = p1.replace(",", ".");
                if (p2.contains(",")) p2 = p2.replace(",", ".");

                double price1 = Double.parseDouble(p1);
                double price2 = Double.parseDouble(p2);

                //TO SORT IN ASCENDING ORDER, CHANGE < TO >
                if (price1 < price2) {
                    String temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
