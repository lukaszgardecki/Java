import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal a = new BigDecimal(scanner.next());
        BigDecimal b = new BigDecimal(scanner.next());
        BigDecimal c = new BigDecimal(scanner.next());
        BigDecimal sum = a.add(b).add(c);
        BigDecimal average = sum.divide(BigDecimal.valueOf(3),0, RoundingMode.DOWN);
        System.out.println(average);
    }
}