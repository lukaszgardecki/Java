import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        long digit1 = Long.parseLong(array[0]);
        long digit2 = Long.parseLong(array[2]);

        switch (array[1]) {
            case "+":
                long sum = digit1 + digit2;
                System.out.println(sum);
                break;
            case "-":
                long subtraction = digit1 - digit2;
                System.out.println(subtraction);
                break;
            case "/":
                if (digit2 == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                long division = digit1 / digit2;
                System.out.println(division);
                break;
            case "*":
                long multiplication = digit1 * digit2;
                System.out.println(multiplication);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}