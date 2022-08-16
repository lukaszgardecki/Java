import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {

        int num;
        do {
            num = scanner.nextInt();
            if (num != 0 && num % 2 == 0) System.out.println(num);
        } while (num != 0);
    }
}