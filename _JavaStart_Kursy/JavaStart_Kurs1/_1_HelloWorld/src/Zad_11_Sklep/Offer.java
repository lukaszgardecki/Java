package Zad_11_Sklep;

class Offer {
    Product product;
    double price;
    boolean special;

    Offer(Product product, double price, boolean special) {
        this.product = product;
        this.price = price;
        this.special = special;
    }

    void displayInfo() {
        System.out.printf("%s %s %sz³, oferta specjalna? %b", product.name, product.producer, price, special);
    }
}
