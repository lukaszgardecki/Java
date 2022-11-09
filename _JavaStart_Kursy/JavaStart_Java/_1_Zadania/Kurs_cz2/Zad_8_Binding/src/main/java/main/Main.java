package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntegerProperty first = new SimpleIntegerProperty();
        IntegerProperty second = new SimpleIntegerProperty();
        second.bind(first);

        System.out.println("Wpisz liczb� ca�kowit�:");
        first.set(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Warto�� second to " + second.get());

        System.out.println("Wpisz liczb� ca�kowit�:");
        first.set(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Warto�� second to " + second.getValue());

        scanner.close();
    }
}
