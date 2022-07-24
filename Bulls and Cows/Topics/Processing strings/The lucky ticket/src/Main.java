import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 3; i++) {
            char nChar = num.charAt(i);
            int nInt = Character.getNumericValue(nChar);
            sum1 += nInt;
        }
        for (int i = 3; i < num.length(); i++) {
            char nChar = num.charAt(i);
            int nInt = Character.getNumericValue(nChar);
            sum2 += nInt;
        }
        if (sum1 == sum2) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}