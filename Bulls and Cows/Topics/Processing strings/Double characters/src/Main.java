import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        String outputText = "";

        for (int i = 0; i < inputText.length(); i++) {
            char sign = inputText.charAt(i);
            outputText += sign;
            outputText += sign;
        }
        System.out.println(outputText);
    }
}