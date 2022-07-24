import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Random random = new Random(a + b);

        for (int i = 0; i < n; i++) {
            int x = random.nextInt(b - a + 1) + a;
            sum += x;
        }
        System.out.println(sum);
    }
}