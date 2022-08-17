import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            deque.push(scanner.nextInt());
        }
        while(deque.size() != 0) {
            System.out.println(deque.pop());
        }

    }
}