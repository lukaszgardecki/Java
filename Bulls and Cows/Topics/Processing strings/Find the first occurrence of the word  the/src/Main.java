import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int w1 = -1;
        int w2 = 0;

        for (int i = 0; i < input.length(); i++) {
            String sign1 = Character.toString(input.charAt(i));
            if (sign1.equalsIgnoreCase("t")) {
                w1 = i;
            } else if (w1 == (i-1) && sign1.equalsIgnoreCase("h")) {
                w2 = i;
            } else if (w2 == (i-1) && sign1.equalsIgnoreCase("e")) {
                break;
            } else {
                w1 = -1;
                w2 = 0;
            }
        }
        System.out.println(w1);
    }
}