package numbers;

import java.util.List;
import java.util.Scanner;

public class Number{
    private final String num;
    private String[] tab;
    private final List<String> propertiesNames = List.of("BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD");

    //konstruktory
    public Number() {
        Scanner scanner = new Scanner(System.in);
        tab = scanner.nextLine().split("\\s+");
        this.num = tab[0];
    }
    public Number(long num) {
        this.num = "" + num ;
    }
    //gettery
    public long getNum() {
        return Long.parseLong(num);
    }
    public long getNum(int i) {
        return Long.parseLong(tab[i]);
    }
    public String getProperty() {
        return tab[2].toUpperCase();
    }
    public final List<String> getPropertiesNames() {
        return propertiesNames;
    }
    public int getAmountOfEl() {
        return tab.length;
    }

    //metody sprawdzaj¹ce liczby
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
        } else if (isDivisibleBy7()) {
            answer = true;
        } else if (endsWith7()) {
            answer = true;
        }
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
    public boolean isSpy() {
        boolean answer = false;
        long product = 1;
        long sum = 0;

        for(int i = 0; i < this.num.length(); i++) {
            sum += Character.getNumericValue(this.num.charAt(i)) ;
            product *= Character.getNumericValue(this.num.charAt(i)) ;
        }
        if(sum == product) {
            answer = true;
        }
        return answer;
    }
}
