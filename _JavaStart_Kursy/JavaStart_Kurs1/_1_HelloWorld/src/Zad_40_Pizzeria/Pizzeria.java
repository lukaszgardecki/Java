package Zad_40_Pizzeria;

import java.util.Arrays;
import java.util.Scanner;

class Pizzeria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witamy w pizzerii NiedobraPizza!");
        System.out.println("-_-_-_- Menu -_-_-_-");
        Arrays.stream(Pizza.values()).forEach(System.out::println);

        System.out.println();

        System.out.println("Aby zam�wi�, wpisz nazw� pizzy: ");
        String input = scanner.nextLine();
        orderPizza(input);
    }

    static void orderPizza(String input) {
        for (Pizza pizza : Pizza.values()) {
            if ((pizza.name()).equals(input.toUpperCase())) {
                    System.out.printf("Zam�wiono pizz� %s!\n", pizza.name());
                return;
            }
        }
        System.out.println("Nie mamy takiej pizzy!");
    }
}
