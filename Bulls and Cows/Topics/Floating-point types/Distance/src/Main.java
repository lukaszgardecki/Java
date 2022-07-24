import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = x / y ;
        System.out.println(z);
    }
}