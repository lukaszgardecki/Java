package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number{
    private final String num;
    private String[] tab;
    private final List<String> propertiesNames = List.of("BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SQUARE", "SUNNY", "JUMPING", "SAD", "HAPPY");

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
    public ArrayList<String> getInputProperties() {
        //String[] tempTab = new String[tab.length-2];
        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 2; i < getAmountOfEl(); i++) {
            tempList.add(tab[i].toUpperCase());
        }
        return tempList;
    }
    public String getInsertProperty(int minimum2) {
        return tab[minimum2].toUpperCase();
    }
    public String getListProperty(int from0) {
        return this.propertiesNames.get(from0);
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
    public boolean isSquare() {
        double sqrt = Math.sqrt(getNum());
        return sqrt - Math.floor(sqrt) == 0;
    }
    public boolean isSunny() {
        boolean answer = false;
        double sqrt = Math.sqrt(getNum() + 1);
        if (sqrt - Math.floor(sqrt) == 0) answer = true;
        return answer;
    }
    public boolean isJumping() {
        boolean answer = false, isNineZero;

        long digit1, digit2, difference;

        if (num.length() > 1) {
            for (int i = 1; i < num.length(); i++) {
                digit1 = num.charAt(i-1);
                digit2 = num.charAt(i);
                difference = Math.abs(digit1 - digit2);
                isNineZero = digit1 == 0 && digit2 == 9
                          || digit1 == 9 && digit2 == 0;

                if (isNineZero || difference != 1) {
                    answer = false;
                    break;
                } else {
                    answer = true;
                }
            }
        } else {
            answer = true;
        }

        return answer;
    }
    public boolean isSad() {
        return !isHappy();
    }
    public boolean isHappy() {
        boolean answer = false;
        String[] digitTab = num.split("");
        int number;
        int sum = 0;

        while (true) {
            //zsumuj kwadraty wszystkich kolejnych cyfr
            for (String s : digitTab) {
                number = (int) Math.pow(Double.parseDouble(s), 2);
                sum += number;
            }
            if (sum == 1) {
                answer = true;
                break;
            }
            if (sum == 4) {
                break;
            }
            String tuptup = Integer.toString(sum);
            digitTab =  tuptup.split("");
            sum = 0;
        }
        return answer;
    }
}
