import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();

        // Your code comes here!
        int hours = minutes / 60;
        int min = minutes % 60;

        System.out.printf("%s hours and %s minutes", hours, min);

        scanner.close();
    }
}