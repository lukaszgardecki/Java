import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> maxValues = new ArrayDeque<>();
        int numOfOperations = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfOperations; i++) {
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("max")) System.out.println(maxValues.peek());
            if (line.equals("pop")) {
                stack.pop();
                maxValues.pop();
            }
            if (line.startsWith("push ")) {
                int num = Integer.parseInt(line.substring(5));
                stack.push(num);
                if (stack.size() == 1) {
                    maxValues.push(num);
                } else if (num > maxValues.peek()) {
                    maxValues.push(num);
                } else {
                    maxValues.push(maxValues.peek());
                }

            }
        }
    }
}