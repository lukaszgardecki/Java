package budget.model;

import java.util.*;

public class Budget {
    private double balance = 0.00;
    private final Set<ProductType> typeList =
            new TreeSet<>(Comparator.comparingInt(ProductType::getValue));

    public Budget() {
        addAllProductTypes();
    }

    public void addAllProductTypes() {
        typeList.addAll(Arrays.asList(ProductType.values()));
    }

    public void addIncome(double income) {
        balance += income;
    }

    public void addNewPurchase(Product product) {
        typeList.stream()
                .filter(type -> type == product.getType() || type == ProductType.ALL)
                .forEach(type -> type.addBoughtProduct(product));

        balance -= product.getPrice();
    }

    public void addType(ProductType type) {
        typeList.add(type);
    }

    public void removeType(ProductType type) {
        typeList.remove(type);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ProductType getProductType(ProductType type) {
        return typeList.stream()
                .filter(t -> t.equals(type))
                .findFirst()
                .orElse(ProductType.ALL);
    }

    public Set<ProductType> getTypeList() {
        return typeList;
    }
}
