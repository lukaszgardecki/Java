import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal num1 = new BigDecimal(scanner.nextLine());
        int newScale = scanner.nextInt();
        BigDecimal x = num1.setScale(newScale, RoundingMode.HALF_DOWN);
        System.out.println(x);
    }   
}