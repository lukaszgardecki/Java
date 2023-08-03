package encryptdecrypt;

import java.util.Scanner;

public class Main {
    static StringBuilder text;
    static char[] abecedario = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encDec = scanner.nextLine();
        text = new StringBuilder(scanner.nextLine());
        int key = scanner.nextInt();

        if (encDec.equalsIgnoreCase("enc")){
            encryption(key);
        } else if (encDec.equalsIgnoreCase("dec")) {
            decryption(key);
        }
        System.out.println(text);
    }

    public static void encryption(int key) {
        for (int i = 0; i < text.length(); i++) {
            for (int k = 0; k < abecedario.length; k++){
                int ch = text.charAt(i);    // e.g. 97
                char cha = text.charAt(i);    // e.g. "a"
                char tab = abecedario[k];

                if (cha == tab) {
                    if(k+key > abecedario.length) {
                        text.replace(i, i+1, String.valueOf(abecedario[k+key - abecedario.length]));
                    } else {
                        text.replace(i, i+1, String.valueOf(abecedario[k+key]));
                    }
                }

            }





//            if(ch + key > 122) {
//                char newSign = (char) (ch + key - 26);
//                text.replace(i,i+1, String.valueOf(newSign));
//            } else {
//                char newSign = (char) (ch + key);
//                text.replace(i,i+1, String.valueOf(newSign));
//            }
        }
    }
    public static void decryption(int key){
        for (int i = 0; i < text.length(); i++) {
            int ch = text.charAt(i);    // e.g. 97
            char newSign = (char) (ch - key);
            text.replace(i,i+1, String.valueOf(newSign));
        }
    }

}
