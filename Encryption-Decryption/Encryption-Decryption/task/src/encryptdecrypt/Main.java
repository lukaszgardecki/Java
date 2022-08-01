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



        Finder finder = null;

//        for (int i = 1; i < args.length; i = i + 2) {
//            String param = args[i - 1];
//            if(param.equalsIgnoreCase("-mode")) {
//                encDec = args[i];
//            }
//            if(param.equalsIgnoreCase("-key")) {
//                key = Integer.parseInt(args[i]);
//            }
//            if(param.equalsIgnoreCase("-data")) {
//                isData = true;
//                data = args[i];
//            }
//            if(param.equalsIgnoreCase("-in")) {
//                isIn = true;
//                path1 = args[i];
//            }
//            if(param.equalsIgnoreCase("-out")) {
//                isOut = true;
//                path2 = args[i];
//            }
//        }

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

//        //encrypt or decrypt
//        if (encDec.equalsIgnoreCase("enc")){
//            encryptionUnicode(key);
//        } else if (encDec.equalsIgnoreCase("dec")) {
//            decryptionUnicode(key);
//        }

        //encrypt or decrypt
        if (encDec.equalsIgnoreCase("enc")){
            finder = new Finder(new EnryptFindingStrategy());
        } else if (encDec.equalsIgnoreCase("dec")) {
            finder = new Finder(new DecryptFindingStrategy());
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

//        if (isOut) {
//            File file2 = new File(path2);
//
//            try (FileWriter writer = new FileWriter(file2)) {
//                writer.write(String.valueOf(text));
//            } catch (IOException e) {
//                System.out.println("Error. File no found: " + path2);
//            }
//        } else {
//            System.out.println(text);
//        }


        finder.find(key, text);

    }


//    public static void encryptionUnicode(int key) {
//        for (int i = 0; i < text.length(); i++) {
//            int ch = text.charAt(i);    // e.g. 97
//            if(ch + key > 122) {
//                char newSign = (char) (ch + key);
//                text.replace(i,i+1, String.valueOf(newSign));
//            } else {
//                char newSign = (char) (ch + key);
//                text.replace(i,i+1, String.valueOf(newSign));
//            }
//        }
//    }
//    public static void decryptionUnicode(int key){
//        for (int i = 0; i < text.length(); i++) {
//            int ch = text.charAt(i);    // e.g. 97
//            char newSign = (char) (ch - key);
//            text.replace(i,i+1, String.valueOf(newSign));
//        }

    }



    /**
     *          W E R S J A 2
     */



    class Finder {
        private FindingStrategy strategy;

        public Finder(FindingStrategy strategy) {
            this.strategy = strategy;
        }

        //wykonanie metody find na obiekcie finder COŒ ROBI
        public void find(String[] ar) {




            strategy.getText(key,text);
        }
    }



    interface FindingStrategy {
        StringBuilder getText(int key, StringBuilder text);
    }

    class DecryptFindingStrategy implements FindingStrategy {
        public StringBuilder getText(int key, StringBuilder text) {
            for (int i = 0; i < text.length(); i++) {
                int ch = text.charAt(i);    // e.g. 97
                char newSign = (char) (ch - key);
                text.replace(i,i+1, String.valueOf(newSign));
            }
            return text;
        }
    }

    class EnryptFindingStrategy implements FindingStrategy {
        public StringBuilder getText(int key, StringBuilder text) {
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
            return text;
        }
    }

}
