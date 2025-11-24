import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int hours = scanner.nextInt();
        System.out.println((float) dist / hours);
    }
}