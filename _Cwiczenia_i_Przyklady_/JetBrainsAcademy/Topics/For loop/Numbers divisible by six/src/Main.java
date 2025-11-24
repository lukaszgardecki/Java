import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int input = scanner.nextInt();
            if (input % 6 == 0) {
                sum += input;
            }
        }
        System.out.println(sum);
    }
}