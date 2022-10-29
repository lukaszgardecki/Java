package Zad_18_LosowaLiczba;

public class NumberUtils {
    void compareNumberAndPrint(int number, int compareTo) {
        if (number == compareTo)
            System.out.println(number + " jest równa " + compareTo);
        else if (number > compareTo)
            System.out.println(number + " jest wiêksza od " + compareTo);
        else
            System.out.println(number + " jest mniejsza od " + compareTo);
    }

    void printOddOrEven(int number) {
        if (number % 2 == 0)
            System.out.println(number + " jest liczb¹ parzyst¹");
        else
            System.out.println(number + " jest liczb¹ nieparzyst¹");
    }

    int getFourDigitNumber(int number) {
        if (number == 0)
            return 0;
        else if (number / 1000 != 0)
            return number;
        else if (number / 100 != 0)
            return number * 10;
        else if (number / 10 != 0)
            return number * 100;
        else
            return number * 1000;
    }
}
