import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal a = new BigDecimal(scanner.nextLine());
        BigDecimal b = new BigDecimal(scanner.nextLine());
        BigDecimal c = new BigDecimal(scanner.nextLine());
        BigDecimal sum = a.add(b).add(c);
        System.out.println(sum);
    }
}