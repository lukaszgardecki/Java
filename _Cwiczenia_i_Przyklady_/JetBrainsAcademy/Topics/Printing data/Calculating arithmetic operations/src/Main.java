import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read two integers from the user
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // TODO: Calculate the sum of num1 and num2
        int sum = num1 + num2;

        // TODO: Calculate the difference of num1 and num2
        int diff = num1 - num2;

        // TODO: Calculate the product of num1 and num2
        int product = num1 * num2;

        // TODO: Calculate the quotient of num1 divided by num2
        int quotient = num1 / num2;


        System.out.println(sum);
        System.out.println(diff);
        System.out.println(product);
        System.out.println(quotient);

        scanner.close();
    }
}