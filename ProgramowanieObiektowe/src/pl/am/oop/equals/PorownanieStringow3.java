package pl.am.oop.equals;

import java.util.Scanner;

public class PorownanieStringow3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nazwa1 = scanner.nextLine();
        String nazwa2 = scanner.nextLine();

        System.out.println(nazwa1 == nazwa2);
        System.out.println(nazwa1.equals(nazwa2));
    }
}
