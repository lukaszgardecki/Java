import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    rec(n);
    }


    public static void rec(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            list.add(1);
            System.out.println(list.get(i) + " ");
        }



    }
}