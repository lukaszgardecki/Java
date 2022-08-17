import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Character> asdf = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        boolean isNotBalanced = false;
        String text = scanner.nextLine();

        for(int i = 0; i < text.length(); i++) {
            char b = text.charAt(i);
            if (b == '(' || b == '[' || b == '{' || b == '<') {
                asdf.add(b);
            } else if (asdf.size() == 0) {
                    isNotBalanced = true;
                    break;
            } else if (asdf.peekLast() == b - 1 || asdf.peekLast() == b - 2) {
                    asdf.removeLast();
            } else {
                    isNotBalanced = true;
                    break;
            }
        }
        System.out.println(asdf.size() == 0 && !isNotBalanced);

    }
}