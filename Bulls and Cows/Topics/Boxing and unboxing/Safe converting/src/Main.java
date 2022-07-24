import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        int x = 0;
        if (val == null) {
            return x;
        } else if (val > Integer.MAX_VALUE) {
            x = Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            x = Integer.MIN_VALUE;
        } else x = Integer.parseInt(String.valueOf(val));
        return x;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}