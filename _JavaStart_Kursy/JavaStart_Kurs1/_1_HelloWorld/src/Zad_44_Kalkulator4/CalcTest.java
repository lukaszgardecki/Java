package Zad_44_Kalkulator4;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

class CalcTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        double a = 0;
        double b = 0;
        String operator = null;

        boolean readComplete = false;
        while (!readComplete) {
            try {
                System.out.println("Podaj pierwsz¹ liczbê:");
                a = input.nextDouble();
                input.nextLine();
                System.out.println("Podaj operator arytmetyczny (+, -, * lub /):");
                operator = input.nextLine();
                System.out.println("Podaj drug¹ liczbê:");
                b = input.nextDouble();
                readComplete = true;
            } catch (InputMismatchException e) {
                System.err.println("Wprowadzono niepoprawne dane, zacznij jeszcze raz");
                input.nextLine();
            }
        }

        try {
            double result = Calc.calculate(a, b, operator);
            System.out.println(a + operator + b + " = " + result);
        } catch (UnknownOperatorException | ArithmeticException e) {
            System.err.println(e.getMessage());
            System.err.println("Nie uda³o siê obliczyæ wyniku wyra¿enia " + a + operator + b);
        }
    }


}
