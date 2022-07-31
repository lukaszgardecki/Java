package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static StringBuilder text;

    public static void main(String[] args) throws IOException {
        String encDec = "enc";
        String path2 = "";
        String data = "";
        String path1 = "";
        boolean isOut = false;
        boolean isData = false;
        boolean isIn = false;
        int key = 0;
        text = new StringBuilder("");

        for (int i = 1; i < args.length; i = i + 2) {
            String param = args[i - 1];
            if(param.equalsIgnoreCase("-mode")) {
                encDec = args[i];
            }
            if(param.equalsIgnoreCase("-key")) {
                key = Integer.parseInt(args[i]);
            }
            if(param.equalsIgnoreCase("-data")) {
                isData = true;
                data = args[i];
            }
            if(param.equalsIgnoreCase("-in")) {
                isIn = true;
                path1 = args[i];
            }
            if(param.equalsIgnoreCase("-out")) {
                isOut = true;
                path2 = args[i];
            }
        }


        if (isData && isIn) {
            text = new StringBuilder(data);
        } else if (isData) {
            text = new StringBuilder(data);
        } else if(isIn) {
            File file1 = new File(path1);

            try (Scanner sc = new Scanner(file1)) {
                try {
                    text = new StringBuilder(sc.nextLine());
                } catch (NoSuchElementException r) {
                    text = new StringBuilder("");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error. File no found: " + path1);
            }
        }

        //encrypt or decrypt
        if (encDec.equalsIgnoreCase("enc")){
            encryption(key);
        } else if (encDec.equalsIgnoreCase("dec")) {
            decryption(key);
        }


        if (isOut) {
            File file2 = new File(path2);

            try (FileWriter writer = new FileWriter(file2)) {
                writer.write(String.valueOf(text));
            } catch (IOException e) {
                System.out.println("Error. File no found: " + path2);
            }
        } else {
            System.out.println(text);
        }
    }

    public static void encryption(int key) {
        for (int i = 0; i < text.length(); i++) {
            int ch = text.charAt(i);    // e.g. 97
            if(ch + key > 122) {
                char newSign = (char) (ch + key);
                text.replace(i,i+1, String.valueOf(newSign));
            } else {
                char newSign = (char) (ch + key);
                text.replace(i,i+1, String.valueOf(newSign));
            }
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
