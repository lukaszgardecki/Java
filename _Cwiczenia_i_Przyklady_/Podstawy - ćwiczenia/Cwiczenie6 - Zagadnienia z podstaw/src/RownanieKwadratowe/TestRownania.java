package RownanieKwadratowe;

import java.util.Scanner;

public class TestRownania {

    public static void main(String[] args) {

        System.out.println("Podaj parametry a, b, i c");
        Scanner skaner = new Scanner(System.in);
        System.out.println("Parametr a: ");
        int a = skaner.nextInt();
        System.out.println("Parametr b: ");
        int b = skaner.nextInt();
        System.out.println("Parametr c: ");
        int c = skaner.nextInt();

        RownanieKwadratowe r = new RownanieKwadratowe(a, b, c);
        System.out.println(r.rozwiaz());
        System.out.println(r);
    }
}
