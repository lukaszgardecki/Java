import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {

        for (int k = 0; k < numbers.length; k++) {
            int max = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (max > numbers[i]) {
                    numbers[i - 1] = numbers[i];
                    numbers[i] = max;
                } else {
                    max = numbers[i];
                }
            }
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}