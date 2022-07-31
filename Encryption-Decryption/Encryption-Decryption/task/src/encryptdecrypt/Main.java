package encryptdecrypt;

import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encDec = scanner.nextLine();
        StringBuilder text = new StringBuilder(scanner.nextLine());
        int key = scanner.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        //ASCII a-z == 97-122
        if (encDec.equalsIgnoreCase("enc")){
            for (int i = 0; i < text.length(); i++) {
                int ch = text.charAt(i);    // e.g. 97
                boolean isSmallLetter = ch >=97 && ch <= 122;
                if(ch + key > 122) {
                    char newSign = (char) (ch + key - 26);
                    text.replace(i,i+1, String.valueOf(newSign));
                } else {
                    char newSign = (char) (ch + key);
                    text.replace(i,i+1, String.valueOf(newSign));
                }
            }
        } else if (encDec.equalsIgnoreCase("dec")) {
            for (int i = 0; i < text.length(); i++) {
                int ch = text.charAt(i);    // e.g. 97
                boolean isSmallLetter = ch >=97 && ch <= 122;
                if(isSmallLetter && ch + key > 122) {
                    char newSign = (char) (ch + key - 26);
                    text.replace(i,i+1, String.valueOf(newSign));
                } else if (isSmallLetter) {
                    char newSign = (char) (ch + key);
                    text.replace(i,i+1, String.valueOf(newSign));
                }
            }
        }

        System.out.println(text);

    }


}
