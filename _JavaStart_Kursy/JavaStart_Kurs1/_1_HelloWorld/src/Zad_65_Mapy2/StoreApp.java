package Zad_65_Mapy2;

import java.io.File;
import java.util.Scanner;

class StoreApp {
    private static Store store;
    private static Scanner scanner;
    public static void main(String[] args) {
        File file = new File("src/Zad_65_Mapy2/products.csv");
        store = new Store(file);
        getInfo();
    }

    private static void getInfo() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj nazwê kategorii dla wyœwietlenia statystyk:");
            System.out.println(store.getCategories());
            String category = scanner.nextLine();
            String info = store.getInfoAbout(category);
            System.out.println(info);
        }
    }
}
