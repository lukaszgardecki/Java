package Zad_52_Rekurencja2;

class Cart {
    private Product[] products = new Product[10];
    private int addedProducts = 0;

    void add(Product product) {
        products[addedProducts] = product;
        addedProducts++;
    }

    double totalCost() {
        return sumPrices(0);
    }

    private double sumPrices(int counter) {
        if (addedProducts == 0) {
            return 0;
        } else if (counter < addedProducts - 1) {
            return products[counter].getPrice() + sumPrices(++counter);
        } else {
            return products[counter].getPrice();
        }
    }
}
