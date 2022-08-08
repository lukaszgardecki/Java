package correcter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int INTERVAL = 3;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
//        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb = new StringBuilder();
//
//        //pobierz tekst
//        String text = scanner.nextLine();
//
//        //Wyœwietl tekst
//        System.out.println(text);
//
//        //Duplikuj ka¿dy znak w tekscie konkretn¹ iloœæ razy (zale¿ne od INTERVAL)
//        for (int i = 0; i < text.length(); i++) {
//            sb.append(String.valueOf(text.charAt(i)).repeat(INTERVAL));
//        }
//        //wyœwietl tekst ze zduplikowanymi znakami:
//        System.out.println(sb);
//
//        //w kazdej sekwencji indentycznych znaków zamieñ 1 znak na inny LOSOWY
//        for (int i = 0; i < sb.length(); i += INTERVAL) {
//            char signBefore;
//            char signAfter;
//            int r2 = random.nextInt(alphabet.length());
//
//            if (sb.length() - i < INTERVAL) {
//                do {
//                    int r3 = random.nextInt(sb.length() - i);
//                    signBefore = sb.charAt(i + r3);   //   text[i + r3];
//                    signAfter = alphabet.charAt(r2);
//                    sb.setCharAt(i + r3, signAfter);
//                } while (signBefore == signAfter);
//            } else {
//                do {
//                    int r1 = random.nextInt(INTERVAL);
//                    signBefore = sb.charAt(i + r1);
//                    signAfter = alphabet.charAt(r2);
//                    sb.setCharAt(i + r1, signAfter);
//                } while (signBefore == signAfter);
//            }
//        }
//
//        //wyœwietl "zaszyfrowany" tekst
//        System.out.println(sb);
//
//        //napraw zepsuty tekst:
//        StringBuilder sb1 = new StringBuilder();
//        char ch = ' ';
//        for (int i = 0; i < sb.length(); i += 3) {
//            String temp = sb.substring(i, i+INTERVAL);
//            if (temp.charAt(0) == temp.charAt(2)) ch = temp.charAt(0);
//            if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2)) ch = temp.charAt(1);
//            sb1.append(ch);
//        }
//
//        //wyœwietl "odszyfrowany" tekst
//        System.out.println(sb1);

        String importPath = "send.txt";
        String outputPath = "received.txt";

        //String importPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\send.txt";
        //String outputPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\received.txt";



        byte[] tab = {};
        try (FileInputStream fileInputStream = new FileInputStream(importPath)) {
            tab = fileInputStream.readAllBytes();
        } catch (IOException e) {
            System.out.println("File not found:");
        }

        //String[] binaryTab = new String[tab.length];
        //byte[] errorTab = new byte[tab.length];
        for (int i = 0; i < tab.length; i++) {
            //binaryTab[i] = Integer.toBinaryString(tab[i]);
            tab[i] ^= 1 <<2;
            //errorTab[i] = tab[i]^1 << random.nextInt(7);
        }

      // System.out.println(Arrays.toString(tab));
        //System.out.println(Arrays.toString(binaryTab));
        //System.out.println(Arrays.toString(errorTab));

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            fileOutputStream.write(tab);
        }catch (IOException e) {
            System.out.println("File not found:");
        }



    }
}
