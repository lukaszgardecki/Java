import javax.swing.plaf.basic.BasicLookAndFeel;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = "abcdefghijklmnoprqstuvwxyz";
        String input = scanner.nextLine();
        int index = 0;
        String alWord;
        boolean answer;


        try {
            String sign = Character.toString(input.charAt(0));
            for (int j = 0; j < alphabet.length(); j++) {
                String alSign = Character.toString(alphabet.charAt(j));
                if (sign.equalsIgnoreCase(alSign)) {
                    index = j;
                    break;
                }
            }
            alWord = alphabet.substring(index, index + input.length());
            answer = input.equalsIgnoreCase(alWord);
            System.out.println(answer);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(false);
        }




    }
}