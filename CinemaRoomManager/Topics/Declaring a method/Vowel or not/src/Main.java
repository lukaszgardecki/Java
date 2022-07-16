import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        char chLow = Character.toLowerCase(ch);
        char[] charArray = {'a', 'e', 'i', 'o', 'u'};
        boolean vowel = false;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == chLow) {
                vowel = true;
                break;
            }
        }
        return vowel;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}