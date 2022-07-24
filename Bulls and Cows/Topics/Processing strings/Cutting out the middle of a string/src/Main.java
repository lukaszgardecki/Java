import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int len = input.length();
        String w1 = "";
        String w2 = "";
        String output = "";


        if (len % 2 == 0) {
                //je¿eli liczba jest parzysta
            w1 = input.substring(0,len/2-1);
            w2 = input.substring(len-w1.length(), len);
            output = w1 + w2;
            System.out.println(output);
        } else {
                //je¿eli liczba jest nieparzysta
            w1 = input.substring(0,len/2);
            w2 = input.substring(len-w1.length(), len);
            output = w1 + w2;
            System.out.println(output);
        }

    }
}