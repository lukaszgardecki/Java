package budget.model;

import java.util.ArrayList;

public enum ProductType {

    FOOD(1,"Food",   new ArrayList<>()),
    CLOTHES(2, "Clothes",  new ArrayList<>()),
    ENTERTAINMENT(3, "Entertainment",  new ArrayList<>()),
    OTHER(4, "Other",  new ArrayList<>()),
    ALL(5, "All",  new ArrayList<>() );

    private final int value;
    private final String name;
    private double totalSum;
    ArrayList<Product> boughtProducts;

    ProductType(int value, String name, ArrayList<Product> boughtProducts) {
        this.value = value;
        this.name = name;
        this.boughtProducts = boughtProducts;
    }

    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public double getTotalSum() {
        return boughtProducts.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
    public ArrayList<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
    public void setBoughtProducts(ArrayList<Product> list) {
        this.boughtProducts = list;
    }

    public void addBoughtProduct(Product product) {
        boughtProducts.add(product);
    }



    @Override
    public String toString() {
        return String.format("%d) %s", value, name);
    }

}
