import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read length and width
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        // Calculate area
        double area = length * width;

        // Print result rounded to two decimal places
        System.out.printf("%.2f", area);
        scanner.close();
    }
}