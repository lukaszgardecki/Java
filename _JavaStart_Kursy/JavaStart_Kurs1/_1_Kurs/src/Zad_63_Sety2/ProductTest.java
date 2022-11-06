package Zad_63_Sety2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ProductTest {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        chooseOption();
    }

    private static void printOptions1() {
        System.out.println("""
                Dostêpne opcje:
                > Dodaj nowy produkt - 0
                > Koniec programu - 1
                """);
    }

    private static void printOptions2() {
        System.out.println("""
                    Znaleziono produkt o takiej nazwie, wybierz co chcesz zrobiæ:
                    > Zignoruj produkt - 0
                    > Nadpisz produkt - 1
                    """);
    }

    private static void chooseOption() {
        while (true) {
            printOptions1();
            System.out.println("Wybierz opcjê:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0 -> addNewProduct();
                case 1 -> exit();
                default -> System.err.println("Wpisz 1 lub 0. Spróbuj jeszcze raz.");
            }
        }

    }

    private static void exit() {
        System.out.println("Wszystkie dodane produkty:");
        System.out.println(products);
        System.exit(0);
    }

    private static void addNewProduct() {
        Product p = createNewProduct();
        boolean isExist = products.contains(p);

        if (isExist) {
            printOptions2();
            int op = scanner.nextInt();
            switch (op) {
                case 0 -> System.out.println("Produkt zignorowany.");
                case 1 -> overrideProduct(p);
                default -> System.out.println("Wpisz 0 lub 1");
            }
        } else {
            products.add(p);
            System.out.println("Produkt dodany do bazy.");
        }
    }

    private static void overrideProduct(Product p) {
        products.remove(p);
        products.add(p);
        System.out.println("Produkt dodany do bazy.");
    }

    private static Product createNewProduct() {
        System.out.println("Podaj nazwê produktu:");
        String name = scanner.nextLine();
        System.out.println("Podaj cenê produktu:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        return new Product(name, price);
    }
}
