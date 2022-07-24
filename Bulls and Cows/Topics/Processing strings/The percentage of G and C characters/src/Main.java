import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double len = input.length();
        int counter = 0;
        double result;

        for (int i = 0; i < len; i++) {
            String sign = Character.toString(input.charAt(i)) ;
            if(sign.equalsIgnoreCase("c") || sign.equalsIgnoreCase("g")) {
                counter++;
            }
        }
        result = counter/len * 100;
        System.out.println(result);
    }
}