package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        turnConverterOn();
    }

    public static void turnConverterOn() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] t;

            try {
                do {
                    System.out.print("\nEnter two numbers in format: {source base} {target base} (To quit type /exit) ");
                    t = scanner.nextLine().split("\\s+");
                    if (t[0].equals("/exit")) return;
                    if (t.length != 2) System.err.println("Enter two numbers! Try again!");
                } while (t.length != 2);

                int base1 = Integer.parseInt(t[0]);
                int base2 = Integer.parseInt(t[1]);

                convert(base1, base2);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Enter two numbers! Try again!");
            }
        }
    }

    public static void convert(int baseFrom, int baseTo) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", baseFrom, baseTo);
            String num = scanner.nextLine();

            if (num.equals("/back")) {
                return;
            } else {
                //je¿eli wpisano potencjaln¹ liczbê dziesiêtn¹
                if (num.contains(".")) {
                    String[] numTab = num.split("\\.");
                    int p = 1;
                    double result = 0;

                    for (int i = 1; i <= numTab[1].length(); i++) {
                        int x = Character.getNumericValue(numTab[1].charAt(i - 1));
                        if (x == 0) continue;
                        result = result + (x * Math.pow(baseFrom, -i));
                    }

                    //liczba po przecinku zaminiona na dziesiêtny system:
                    numTab[1] = Double.toString(result).substring(Double.toString(result).indexOf(".") + 1);

                    double num2 = result;

                    int amountOfNums = 5; // -> iloœæ miejsc po przecinku, które chcemy
                    StringBuilder newNum = new StringBuilder("");
                    String[] temp;

                    for (int i = 0; i < amountOfNums; i++) {
                        num2 = num2 * baseTo;
                        temp = Double.toString(num2).split("\\.");
                        num2 = Double.parseDouble("0." + temp[1]);
                        newNum.append(Integer.toString(Integer.parseInt(temp[0]), baseTo));
                    }

                    String k = integerConvert(numTab[0], baseFrom, baseTo);
                    System.out.printf("Conversion result: %s.%s\n\n", k, newNum);
                }

                //je¿eli wpisano liczbê ca³kowit¹
                else {
                    String m = integerConvert(num, baseFrom, baseTo);
                    System.out.printf("Conversion result: %s\n\n", m);
                }
            }
        }
    }

    public static String integerConvert(String num, int baseFrom, int baseTo) {
        BigInteger n = new BigInteger(num, baseFrom);
        String n2 = n.toString();
        return new BigInteger(n2).toString(baseTo);
    }
}










