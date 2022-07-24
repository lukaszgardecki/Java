import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] abc = scanner.nextLine().split("-");
        System.out.printf("%s/%s/%s", abc[1], abc[2], abc[0]);
    }
}