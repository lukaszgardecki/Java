import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal money = new BigDecimal(scanner.nextLine());
        BigDecimal rate = new BigDecimal(scanner.nextLine());
        int years = scanner.nextInt();
        BigDecimal x1 = money.multiply((rate
                            .divide( BigDecimal
                            .valueOf(100),2 , RoundingMode.CEILING)
                            .add(BigDecimal.ONE))
                            .pow(years));
        BigDecimal res = x1.setScale(2, RoundingMode.CEILING);
        System.out.println("Amount of money in the account: " + res);
    }
}