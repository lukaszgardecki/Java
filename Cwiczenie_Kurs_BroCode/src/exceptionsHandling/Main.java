package exceptionsHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Dzielenie. WprowadŸ lizbê 1: ");
            int x = scanner.nextInt();

            System.out.println("Dzielenie. WprowadŸ lizbê 2: ");
            int y = scanner.nextInt();

            int z = x / y;

            System.out.println("wynik: " + z);
        } catch (ArithmeticException e) {
            System.out.println("Nie mo¿esz dzieliæ przez zero!");
        } catch (InputMismatchException e) {
            System.out.println("WprowadŸ liczbê...");
        } catch (Exception e) {
            System.out.println("Coœ posz³o nie tak.");
        } finally {
            scanner.close();
        }
    }
}
