package numbers;

import java.util.Scanner;

public class Number{
    Scanner scanner = new Scanner(System.in);
    int num = Integer.parseInt(scanner.nextLine());


    public int getNum() {
        return num;
    }
    public boolean isNatural() {
        return getNum() >= 1;
    }
    public boolean isEven() {
        return getNum() % 2 == 0;
    }
    public boolean isOdd() {
        return getNum() % 2 != 0;
    }
    public boolean isDivisibleBy7() {
        return num % 7 == 0;
    }
    public boolean endsWith7() {
        return num % 10 == 7;
    }
    public boolean isBuzzNumber() {
        boolean answer = false;

        if (isDivisibleBy7() && endsWith7()) {
            answer = true;
//            System.out.printf("It is a Buzz number:\nExplanation:\n%d is divisible by 7 and ends with 7.", num);
        } else if (isDivisibleBy7()) {
            answer = true;
//            System.out.printf("It is a Buzz number:\nExplanation:\n%d is divisible by 7.", num);
        } else if (endsWith7()) {
            answer = true;
//            System.out.printf("It is a Buzz number:\nExplanation:\n%d ends with 7.", num);
        } /*else {
//            System.out.printf("It is not a Buzz number.\nExplanation:\n%d is neither divisible by 7 nor does it end with 7.", num);
        }*/
        return answer;
    }
    public boolean isDuckNumber() {
        return String.valueOf(num).substring(1).contains("0");
    }
}
