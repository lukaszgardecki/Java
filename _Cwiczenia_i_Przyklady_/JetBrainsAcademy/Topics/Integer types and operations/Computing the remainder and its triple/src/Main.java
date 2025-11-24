import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int remainder = input % 2;
        System.out.println(remainder);
        int result = remainder * 3;
        System.out.println(result);

        scanner.close();
    }
}