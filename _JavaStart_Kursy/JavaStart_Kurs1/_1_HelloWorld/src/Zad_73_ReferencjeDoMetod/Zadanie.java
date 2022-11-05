package Zad_73_ReferencjeDoMetod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

class Zadanie {
    public static void main(String[] args) {
        String[] names = {"Kasia", "Kamil", "£ukasz", "Zygmunt", "Dawid", "Emila"};
        Random random = new Random();
        List<String> list = new ArrayList<>();

        System.out.println(">>> Wygenerowanie listy z losowymi imionami:");
        generateList(list, 10, () -> names[random.nextInt(names.length)]);
        list.forEach(e -> System.out.print(e + " "));

        System.out.println();

        System.out.println(">>> Uporz¹dkowanie tej listy w kolejnoœci rosn¹cej: ");
        list.sort(String::compareToIgnoreCase);
        list.forEach(e -> System.out.print(e + " "));
    }

    private static <T> void generateList(List<T> list, int num, Supplier<T> supplier) {
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
    }
}
