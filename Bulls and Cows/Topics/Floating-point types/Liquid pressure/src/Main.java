import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ro = scanner.nextDouble();
        double h = scanner.nextDouble();
        double r = ro * h * 9.8;
        System.out.println(r);
    }
}