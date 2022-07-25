package numbers;

import java.util.Scanner;

public class Number{
    private Scanner scanner;
    private String num;
    private String[] tab;

    public Number() {
        scanner = new Scanner(System.in);
        tab = scanner.nextLine().split("\\s+");
        this.num = tab[0];
        //this.amount = tab[1];
    }
    public Number(int num) {
        //this.tab[0] = String.valueOf(num);
        //this.num = this.tab[0];
        this.num = "" + num  ;
    }

    public long getNum() {
        return Long.parseLong(num);
    }
    public long getNum(int i) {
        return Long.parseLong(tab[i]);
    }
    public int amountOfEl() {
        return tab.length;
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
        return getNum() % 7 == 0;
    }
    public boolean endsWith7() {
        return getNum() % 10 == 7;
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
        return String.valueOf(getNum()).substring(1).contains("0");
    }
    public boolean isPalindromic() {
        StringBuilder s1 = new StringBuilder();
        String x = Long.toString(getNum());
        return x.contentEquals(s1.append(getNum()).reverse());
    }
    public boolean isGapful() {
        boolean answer = false;
        if (this.num.length() > 2) {
            String first = Character.toString(this.num.charAt(0));
            String last = Character.toString(this.num.charAt(this.num.length()-1)) ;
            long x = Long.parseLong(this.num);
            long y = Long.parseLong(first+last);
            if (x % y == 0) {
                answer = true;
            }
        }
        return answer;
    }
}
