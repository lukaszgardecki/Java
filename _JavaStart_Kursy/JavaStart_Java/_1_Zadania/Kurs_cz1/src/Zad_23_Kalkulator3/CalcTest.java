package Zad_23_Kalkulator3;

import java.util.Scanner;

class CalcTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc();

        System.out.println("Wprowad� liczb� 1:");
        double num1 = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Wprowad� znak operacji matematycznej [+, -, *, /]:");
        String sign = scanner.nextLine();

        System.out.println("Wprowad� liczb� 2:");
        double num2 = scanner.nextDouble();

        double result = calc.doOperation(num1, num2, sign);
        System.out.println("Wynik: " + result);
    }
}
