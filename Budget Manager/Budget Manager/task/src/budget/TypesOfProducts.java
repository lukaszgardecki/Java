package budget;

import java.util.ArrayList;

public enum TypesOfProducts {

    FOOD("Food", 0,  new ArrayList<>()),
    CLOTHES("Clothes", 0, new ArrayList<>()),
    ENTERTAINMENT("Entertainment", 0, new ArrayList<>()),
    OTHER("Other", 0, new ArrayList<>()),
    ALL("All", 0, new ArrayList<>() );

    final String name;
    final double sum;
    final ArrayList<String> boughtProducts;

    TypesOfProducts(String name, double sum, ArrayList<String> boughtProducts) {
        this.name = name;
        this.sum = sum;
        this.boughtProducts = boughtProducts;
    }

}
