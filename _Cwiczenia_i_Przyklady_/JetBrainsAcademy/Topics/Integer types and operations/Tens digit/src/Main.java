import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int res = i % 100 / 10;

        System.out.println(res);
        scanner.close();
    }
}