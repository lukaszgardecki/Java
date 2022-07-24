import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String check = scanner.nextLine();
        String checkFirstSign = Character.toString(check.charAt(0));
        int len = check.length();
        int counter = 0;
        int index = 0;

//        while (input.length() > check.length()) {
//
//            for (int i = 0; i < input.length(); i++) {
//                if(checkFirstSign.equals(Character.toString(input.charAt(i)))) {
//                    index = i;
//                    break;
//                }
//            }
//            String newWord = input.substring(index, index+len);
//            if (check.equals(newWord)) {
//                counter++;
//            }
//            input = input.substring(index + len);
//        }
//        System.out.println(counter);

        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);




    }
}