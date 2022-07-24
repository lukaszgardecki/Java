import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int counter = 1;

        if (input.length() == 1) {
            String word = Character.toString(input.charAt(0)) + counter;
            System.out.print(word);
        } else {
            for (int i = 1; i < input.length(); i++) {
                boolean x = input.charAt(i-1)==input.charAt(i);

                if (x && i == input.length()-1) {
                    counter++;
                    String word = Character.toString(input.charAt(i)) + counter;
                    System.out.print(word);
                } else if (x) {
                    counter++;
                } else {
                    String word = Character.toString(input.charAt(i-1)) + counter;
                    System.out.print(word);
                    counter = 1;

                    if (i == input.length() -1) {
                        word = Character.toString(input.charAt(i)) + counter;
                        System.out.print(word);
                    }
                }
            }
        }
    }
}