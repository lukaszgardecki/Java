package exceptionsHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Dzielenie. Wprowad� lizb� 1: ");
            int x = scanner.nextInt();

            System.out.println("Dzielenie. Wprowad� lizb� 2: ");
            int y = scanner.nextInt();

            int z = x / y;

            System.out.println("wynik: " + z);
        } catch (ArithmeticException e) {
            System.out.println("Nie mo�esz dzieli� przez zero!");
        } catch (InputMismatchException e) {
            System.out.println("Wprowad� liczb�...");
        } catch (Exception e) {
            System.out.println("Co� posz�o nie tak.");
        } finally {
            scanner.close();
        }
    }
}
