package budget;

public class Product {
    private final String name;
    private final double price;
    private ProductType type;

    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    public void setProductType(ProductType productType) {
        this.type = productType;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, price);
    }
}
