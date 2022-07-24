import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int seed = 0;
        int max = 0;
        int min = k;

        for (int s = a; s <= b; s++) {
            Random random = new Random(s);
            for (int i = 0; i < n; i++) {
                int x = random.nextInt(k);
                if (x > max) {
                    max = x;
                }
            }
            if (max < min) {
                min = max;
                seed = s;

            }
            max = 0;
        }
        System.out.println(seed);
        System.out.println(min);
    }
}