package Zad_52_Rekurencja2;

class Shop {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product p1 = new Product("Kalkulator", 120);
        Product p2 = new Product("Telefon", 2456.78);
        Product p3 = new Product("D�ugopis", 1.89);
        Product p4 = new Product("S�uchawki", 478.34);
        Product p5 = new Product("Papier", 8.23);

        cart.add(p1);
        cart.add(p2);
        cart.add(p3);
        cart.add(p4);
        cart.add(p5);

        double totalPrice = cart.totalCost();
        System.out.printf("Warto�� wszystkich produkt�w w koszyku: %.2f%nz�", totalPrice);
    }
}
