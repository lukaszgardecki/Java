import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int units = scanner.nextInt();
        String msg = units >= 1000 ? "legion" : units >= 250 ? "zounds" : units >= 20 ? "throng" : units >= 1 ? "pack" : "no army";
        System.out.println(msg);
    }
}