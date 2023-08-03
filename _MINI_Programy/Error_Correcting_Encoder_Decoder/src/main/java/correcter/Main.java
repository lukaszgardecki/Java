package correcter;

//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        System.out.print("Write a mode: ");
//        Scanner sc = new Scanner(System.in);
//        String mode = sc.nextLine().trim().toLowerCase();
//
//        Decoder decoder = new Decoder();
//        switch (mode) {
//            case "encode":
//                decoder.encode();
//                break;
//            case "send":
//                decoder.send();
//                break;
//            case "decode":
//                decoder.decode();
//                break;
//            default:
//                System.out.println("Wrong mode!");
//                break;
//        }
//    }
//}
//
//





































import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);


    private static final String SEND_FILE = "send.txt";
    private static final String ENCODE_FILE = "encoded.txt";
    private static final String RECEIVE_FILE = "received.txt";
    private static final String DECODE_FILE = "decoded.txt";

//    private static final String SEND_FILE = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\send.txt";
//    private static final String ENCODE_FILE = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\encoded.txt";
//    private static final String RECEIVE_FILE = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\received.txt";
//    private static final String DECODE_FILE = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\decoded.txt";


    public static void main(String[] args) throws IOException {
        System.out.print("Write a mode: ");
        String mode = SCANNER.next();
        System.out.println();
        switch (mode.toLowerCase()) {
            case "encode":
                encodeInstruction();
                break;
            case "send":
                sendInstruction();
                break;
            case "decode":
                decodeInstruction();
                break;
            default:
        }
    }

    /** ===================================================================== */

    private static void encodeInstruction() throws IOException {
        String data = getBinFromByte(readFromFile(SEND_FILE)); //01010100011001010111001101110100
        String encoded = encode(data);      //0100101010011000110011000100101000011110100001100001111010011000
        String encodedAdded = add(encoded); //01001010 10011000 11001100 01001010 00011110 10000110 00011110 10011000 //dodaje zera
        saveToFileAsByte(ENCODE_FILE, getByteFromBin(encodedAdded));


        //System.out.println(Arrays.toString(readFromFile(SEND_FILE)));
        //System.out.println(getBinFromByte(readFromFile(SEND_FILE)));
        //System.out.println(encoded);
        //System.out.println(encodedAdded);
        System.out.println(Arrays.toString(getByteFromBin(encodedAdded)));


        System.out.println(SEND_FILE + ":");
        System.out.println("text view: " + getTextFromBin(data));
        System.out.println("hex view: " + getHexFromBin(data));
        System.out.println("bin view: " + getBinWithSpacesFromBin(data) + "\n");
        System.out.println(ENCODE_FILE + ":");
        System.out.println("expand: " + getParityFromBinWithSpaces(getBinWithSpacesFromBin(encodedAdded)));
        System.out.println("parity: " + getBinWithSpacesFromBin(encodedAdded));
        System.out.println("hex view: " + getHexFromBin(encodedAdded));
    }

    private static void sendInstruction() throws IOException {
        String data = getBinFromByte(readFromFile(ENCODE_FILE));
        String error = send(data);
        saveToFileAsByte(RECEIVE_FILE, getByteFromBin(error));
        System.out.println(ENCODE_FILE + ":");
        System.out.println("hex view: " + getHexFromBin(data));
        System.out.println("bin view: " + getBinWithSpacesFromBin(data) + "\n");
        System.out.println(RECEIVE_FILE + ":");
        System.out.println("bin view: " + getBinWithSpacesFromBin(error));
        System.out.println("hex view: " + getHexFromBin(error));
    }

    private static void decodeInstruction() throws IOException {
        String data = getBinFromByte(readFromFile(RECEIVE_FILE));
        String decoded = decode(data);
        String decodedRemove = remove(decoded);
        saveToFileAsByte(DECODE_FILE, getByteFromBin(decodedRemove));
        System.out.println(RECEIVE_FILE + ":");
        System.out.println("hex view: " + getHexFromBin(data));
        System.out.println("bin view: " + getBinWithSpacesFromBin(data) + "\n");
        System.out.println(DECODE_FILE + ":");
        System.out.println("correct: " + getBinWithSpacesFromBin(encode(decoded)));
        System.out.println("decode: " + getBinWithSpacesFromBin(decoded));
        System.out.println("hex view: " + getHexFromBin(decodedRemove));
        System.out.println("text view: " + getTextFromBin(decodedRemove));
    }

    /** ===================================================================== */

    private static String getHexFromBin(String data) {
        StringBuilder result = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (i % 4 == 0 && i != 0) {
                int decimal = Integer.parseInt(builder.toString(), 2);
                String hex = Integer.toString(decimal, 16).toUpperCase();
                result.append(hex);
                if (i % 8 == 0) {
                    result.append(" ");
                }
                builder.delete(0, 4);
            }
            builder.append(data.charAt(i));
        }
        int decimal = Integer.parseInt(builder.toString(), 2);
        String hex = Integer.toString(decimal, 16).toUpperCase();
        result.append(hex);
        return result.toString();
    }

    private static String getBinWithSpacesFromBin(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (i % 8 == 0 && i != 0) {
                result.append(" ");
            }
            result.append(data.charAt(i));
        }
        return result.toString();
    }

    private static String getParityFromBinWithSpaces(String data) {
        StringBuilder result = new StringBuilder(data);
        for (int i = 0; i < data.length(); i += (Byte.SIZE + 1)) {
            result.setCharAt(i, '.');
            result.setCharAt(i + 1, '.');
            result.setCharAt(i + 3, '.');
            result.setCharAt(i + 7, '.');
        }
        return result.toString();
    }

    private static String getBinFromByte(byte[] data) {
        StringBuilder result = new StringBuilder();
        for (byte datum : data) {
            for (int j = Byte.SIZE - 1; j >= 0 ; j--) {
                result.append((datum >> j) & 1);
            }
        }
        return result.toString();
    }

    private static String getTextFromBin(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i += Byte.SIZE) {
            result.append((char) Integer.parseInt(data.substring(i, Byte.SIZE + i), 2));
        }
        return result.toString();
    }

    private static byte[] getByteFromBin(String data) {
        String[] bytes = data.split("(?<=\\G.{8})");            //podziel string na kawa³ki po 8 znaków
        byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = (byte) Integer.parseInt(bytes[i], 2);
        }
        return result;
    }

    /** ===================================================================== */

    private static String encode(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 3; i < data.length(); i += 4) {
            int s1 = Character.getNumericValue(data.charAt(i - 3));
            int s2 = Character.getNumericValue(data.charAt(i - 2));
            int s3 = Character.getNumericValue(data.charAt(i - 1));
            int s4 = Character.getNumericValue(data.charAt(i));
            int p1 = (s1 + s2 + s4) % 2;
            int p2 = (s1 + s3 + s4) % 2;
            int p3 = (s2 + s3 + s4) % 2;
            result.append(p1).append(p2).append(s1).append(p3).
                    append(s2).append(s3).append(s4).append("0");
        }
        return result.toString();
    }

    private static String decode(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = Byte.SIZE - 1; i < data.length(); i += Byte.SIZE) {
            int errorPos = 0;
            int[] h = new int[8];
            for (int j = 0; j < 8; j++) {
                h[j] = Character.getNumericValue(data.charAt(j + i - 7));
            }
            if (h[0] != (h[2] + h[4] + h[6]) % 2) {
                errorPos += 1;
            }
            if (h[1] != (h[2] + h[5] + h[6]) % 2) {
                errorPos += 2;
            }
            if (h[3] != (h[4] + h[5] + h[6]) % 2) {
                errorPos += 4;
            }
            if (errorPos != 0) {
                h[errorPos - 1] = h[errorPos - 1] == 1 ? 0 : 1;
            }
            result.append(h[2]).append(h[4]).append(h[5]).append(h[6]);
        }
        return result.toString();
    }

    private static String send(String data) {
        Random random = new Random();
        StringBuilder result = new StringBuilder(data);
        for (int i = Byte.SIZE - 1; i < data.length(); i += Byte.SIZE) {
            int pos = i - random.nextInt(Byte.SIZE);
            result.setCharAt(pos, result.charAt(pos) == '1' ? '0' : '1');
        }
        return result.toString();
    }

    private static String remove(String data) {
        StringBuilder result = new StringBuilder(data);
        while (result.length() % Byte.SIZE  != 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static String add(String data) {
        StringBuilder result = new StringBuilder(data);
        while (result.length() % Byte.SIZE != 0) {
            result.append("0");
        }
        return result.toString();
    }

    /** ===================================================================== */

    private static byte[] readFromFile(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    private static void saveToFileAsByte(String fileName, byte[] data) throws IOException {
        FileOutputStream output = new FileOutputStream(new File(fileName));
        output.write(data);
        output.close();
    }
}





























//package correcter;
//import java.io.*;
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Main {
//
//
//
//    private static final int INTERVAL = 3;
////    static String sendPath = "send.txt";
////    static String receivedPath = "received.txt";
////    static String encodedPath = "encoded.txt";
////    static String decodedPath = "decoded.txt";
//
//    static String sendPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\send.txt";
//    static String receivedPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\received.txt";
//    static String encodedPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\encoded.txt";
//    static String decodedPath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Error Correcting Encoder-Decoder\\Error Correcting Encoder-Decoder\\task\\src\\correcter\\decoded.txt";
//
//    static File sendFile = new File(sendPath);
//    static File encodedFile = new File(encodedPath);
//    static File receivedFile = new File(receivedPath);
//    static File decodedFile = new File(decodedPath);
//
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Write a mode: ");
//        String mode = scanner.nextLine().toLowerCase();
//        switch (mode) {
//            case "encode":
//                encode();
//                break;
//            case "send":
//                send();
//                break;
//            case "decode":
//                decode();
//                break;
//            default:
//                break;
//        }
////        try (FileOutputStream fileOutputStream = new FileOutputStream(receivedPath)) {
////            fileOutputStream.write(newBinaryTab);
////        }catch (IOException e) {
////            System.out.println("File not found:");
////        }
//    }
//
//
//    public static void send() {
//        String[] tab1;
//        String[] tab2;
//        String[] errorTab;
//        String[] tab3;
//        String wholeText = "";
//        Random random = new Random();
//
//        //Pobierz dane:
//        try (Scanner sc = new Scanner(encodedFile)) {
//            wholeText = sc.nextLine();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found:");
//        }
//
//
//        //wersja 1:
////        //stwórz tabelê z pobranymi danymi BINARNYMI:
////        int amountOfNums = wholeText.length() / 8;
////        tab1 = new String[amountOfNums];
////        for (int i = 0; i < amountOfNums; i++) {
////            tab1[i] = wholeText.substring((i * 8), 8+(i*8));
////        }
//        //wersja 2:
//        //stwórz tabelê z pobranymi danymi (liczby HEX):
//        int amountOfNums = wholeText.length() / 2;
//        tab1 = new String[amountOfNums];
//        for (int i = 0; i < amountOfNums; i++) {
//            tab1[i] = wholeText.substring((i * 2), 2+(i*2));
//        }
//
//
//
//
//        tab2 = new String[tab1.length];
//        tab3 = new String[tab1.length];
//        errorTab = new String[tab1.length];
//
//
//
//
//
////        //wersja 1:
////        //stwórz tabelê z liczbami binarnymi, w których jest symulowany b³¹d
////        for (int i = 0; i < tab1.length; i++) {
////            int ran = random.nextInt(8);
////
////            tab2[i] = Integer.toHexString(Integer.parseInt(tab1[i], 2)).toUpperCase();
////
////            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
////            if (tab2[i].length() == 1) {
////                tab2[i] = "0" + tab2[i];
////            }
////
////            //wersja 1:
////            StringBuilder temp = new StringBuilder(tab1[i]);
////
////            //System.out.println(temp);
////
////            //symulacja b³êdu (wprowadŸ error):
////            if (temp.charAt(ran) == '1') {
////                temp.setCharAt(ran, '0');
////            } else if (temp.charAt(ran) == '0') {
////                temp.setCharAt(ran, '1');
////            }
////
////            errorTab[i] = temp.toString();
////            tab3[i] = Integer.toHexString(Integer.parseInt(errorTab[i], 2)).toUpperCase();
////
////            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
////            if (tab3[i].length() == 1) {
////                tab3[i] = "0" + tab3[i];
////            }
////        }
//
//
//
//        //wersja 2:
//        //stwórz tabelê z liczbami binarnymi, w których jest symulowany b³¹d
//        for (int i = 0; i < tab1.length; i++) {
//            int ran = random.nextInt(8);
//
//            //wersja 1:
////            tab2[i] = Integer.toHexString(Integer.parseInt(tab1[i], 2)).toUpperCase();
//            //wersaj 2:
//
//
//            //stworzenie tablicy z liczbami binarnymi
//            tab2[i] = Integer.toBinaryString(Integer.parseInt(tab1[i], 16));
//
//
//
//
//
//
//
////            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
////            if (tab2[i].length() == 1) {
////                tab2[i] = "0" + tab2[i];
////            }
//
//            //wersja 1:
////            StringBuilder temp = new StringBuilder(tab1[i]);
//            //wersja 2:
//            StringBuilder temp = new StringBuilder(tab2[i]);
//            temp.insert(0, "0".repeat(8-temp.length()));
//
//
//
//            System.out.println(temp);
//
//            //symulacja b³êdu (wprowadŸ error):
//            if (temp.charAt(ran) == '1') {
//                temp.setCharAt(ran, '0');
//            } else if (temp.charAt(ran) == '0') {
//                temp.setCharAt(ran, '1');
//            }
//
//            errorTab[i] = temp.toString();
//            tab3[i] = Integer.toHexString(Integer.parseInt(errorTab[i], 2)).toUpperCase();
//
//            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
//            if (tab3[i].length() == 1) {
//                tab3[i] = "0" + tab3[i];
//            }
//        }
//
//
//
//
//
//
//
//
//
//
//
//        //zapisanie do pliku:
//        try (FileWriter fileWriter = new FileWriter(receivedPath)) {
//            fileWriter.write(stringTabToFile(errorTab));
//        }catch (IOException e) {
//            System.out.println("File not found:");
//        }
//
//
//        System.out.println(Arrays.toString(tab2));
//
//
//        //Wyœwietl informacje w konsoli:
//        System.out.printf("%s:\n", encodedPath);
//        System.out.printf("hex view: %s\n", stringTab(tab2));
//        System.out.printf("bin view: %s\n", stringTab(tab1));
//
//        System.out.println();
//
//        System.out.printf("%s:\n", receivedPath);
//        System.out.printf("bin view: %s\n", stringTab(errorTab));
//        System.out.printf("hex view: %s\n", stringTab(tab3));
//    }
//
//
//
//
//
//
//
//
//
//    public static void encode() {
//        byte[] decTab = {};
//        String text = "";
//
//        //Pobierz wprowadzony tekst:
//        try (Scanner sc = new Scanner(sendFile)) {
//            text = sc.nextLine();
//        } catch (FileNotFoundException e) {
//            //System.out.println("File not found:");
//        }
//
//        //Tekst z pliku zamieñ na bajty
//        try (FileInputStream fileInputStream = new FileInputStream(sendPath)) {
//            decTab = fileInputStream.readAllBytes();
//        } catch (IOException e) {
//            //System.out.println("File not found:");
//        }
//
//        String[] binTab = new String[decTab.length];
//        String[] hexTab = new String[decTab.length];
//
//        //Stworzenie jednego ci¹gu znaków z liczb binarnych
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < binTab.length; i++) {
//            binTab[i] = Integer.toBinaryString((decTab[i] & 0xFF) + 0x100).substring(1);
//
//            hexTab[i] = Integer.toHexString(decTab[i]).toUpperCase();
//            //decTab[i] ^= 1 <<2;
//            stringBuilder.append(binTab[i]);
//        }
//
//
//        //System.out.println(stringBuilder);
//
//
//
//        //dodanie na koñcu ³añcucha brakuj¹cych zer, tak aby d³ugoœæ by³a podzielna przez 3
//        int lastBit = stringBuilder.length() % 3;
//        int addedZeros = 3 - lastBit;
//        if (lastBit != 0) {
//            stringBuilder.append("0".repeat(addedZeros));
//        }
//
//        //Stworzenie tabeli, która bêdzie przechowywaæ utworzone ze stringBuildera NOWE liczby binarne:
//        String[] newBinaryTab = new String[stringBuilder.length()/3];
//        String[] newHexTab = new String[stringBuilder.length()/3];
//        String[] tempTab = new String[stringBuilder.length()/3];
//
//
//        int counter = 0;
//        //dodanie elementów do tabeli:
//        for (int i = 0; i < stringBuilder.length(); i+=3) {
//            //kolejny znak w stringbuilderze
//            String num1 = String.valueOf(stringBuilder.charAt(i));
//            String num2 = String.valueOf(stringBuilder.charAt(i+1));
//            String num3 = String.valueOf(stringBuilder.charAt(i+2));
//            String num4 = String.valueOf((Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3)) % 2);
//
//            //stwórz now¹ liczbê binarn¹ i dodaj j¹ do tablicy:
//            String x = String.format("%s%s%s%s%s%s%s%s", num1, num1, num2, num2, num3, num3, num4, num4);
//            String x1 = String.format("%s%s%s%s%s%s..", num1, num1, num2, num2, num3, num3);
//            newBinaryTab[counter] = x;
//
//            tempTab[counter] = x1;
//
//
//            //zamiana liczby binarnej na hexadecymaln¹:
//            String hexNum = Integer.toHexString(Integer.parseInt(x, 2)).toUpperCase();
//
//            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
//            if (hexNum.length() == 1) {
//                newHexTab[counter] = "0" + hexNum;
//            } else {
//                newHexTab[counter] = hexNum;
//            }
//            counter++;
//        }
//
//        //edycja ostatniego elementu w tabeli tempTab:
//        if(addedZeros == 1) {
//            String part1 = tempTab[tempTab.length-1].substring(0, 4);
//            String stringNew = String.format("%s....", part1);
//            tempTab[tempTab.length-1] = stringNew;
//        } else if (addedZeros == 2) {
//            String part1 = tempTab[tempTab.length-1].substring(0, 2);
//            String stringNew = String.format("%s......", part1);
//            tempTab[tempTab.length-1] = stringNew;
//        }
//
//
//        //zapisanie danych do pliku
////        File file = new File(encodedPath);
//        try (FileWriter fileWriter = new FileWriter(encodedFile)) {
//            fileWriter.write(stringTabToFile(newHexTab));
//        }catch (IOException e) {
//            System.out.println("File not found:");
//        }
//
//
//        //Wyœwietl informacje w konsoli:
//        System.out.printf("%s:\n", sendPath);
//        System.out.printf("text view: %s\n", text);
//        System.out.printf("hex view: %s\n", stringTab(hexTab));
//        System.out.printf("bin view: %s\n", stringTab(binTab));
//
//        System.out.println();
//
//        System.out.printf("%s:\n", encodedPath);
//        System.out.printf("expand: %s\n", stringTab(tempTab));
//        System.out.printf("parity: %s\n", stringTab(newBinaryTab));
//        System.out.printf("hex view: %s\n", stringTab(newHexTab));
//
//    }
//
//    public static void decode() {
//        String[] tab1;
//        String[] tab2;
//        String[] tab3;
//        String[] tab4;
//        String[] tab5;
//        String[] decodedTab;
//        String wholeText = "";
//        StringBuilder str = new StringBuilder();
//
////        //pobierz dane z receivedFile:
////        try (Scanner sc = new Scanner(receivedFile)) {
////            tab1 = sc.nextLine().split("\\s+");
////        } catch (FileNotFoundException e) {
////            System.out.println("File not found:");
////        }
//
//
//        //Pobierz dane:
//        try (Scanner sc = new Scanner(encodedFile)) {
//            wholeText = sc.nextLine();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found:");
//        }
//        //stwórz tabelê z pobranymi danymi:
//        int amountOfNums = wholeText.length() / 8;
//        tab1 = new String[amountOfNums];
//        for (int i = 0; i < amountOfNums; i++) {
//            tab1[i] = wholeText.substring((i * 8), 8+(i*8));
//        }
//
//
//
//
//
//
//
//        tab2 = new String[tab1.length];
//        tab3 = new String[tab1.length];
//
//
//        //stwórz tabelê z liczbami binarnymi, w których jest symulowany b³¹d
//        for (int i = 0; i < tab1.length; i++) {
//
//            tab2[i] = Integer.toHexString(Integer.parseInt(tab1[i], 2)).toUpperCase();
//
//            //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
//            if (tab2[i].length() == 1) {
//                tab2[i] = "0" + tab2[i];
//            }
//
//            int n1 = Integer.parseInt(String.valueOf(tab1[i].charAt(0)));
//            int n2 = Integer.parseInt(String.valueOf(tab1[i].charAt(1)));
//            int n3 = Integer.parseInt(String.valueOf(tab1[i].charAt(2)));
//            int n4 = Integer.parseInt(String.valueOf(tab1[i].charAt(3)));
//            int n5 = Integer.parseInt(String.valueOf(tab1[i].charAt(4)));
//            int n6 = Integer.parseInt(String.valueOf(tab1[i].charAt(5)));
//            int n7 = Integer.parseInt(String.valueOf(tab1[i].charAt(6)));
//
//            StringBuilder ss = new StringBuilder();
//
//            if (n1 == n2 && n3 == n4 && n5 == n6) {
//                n7 = (n1 + n3 + n5) % 2;
//            } else if (!(n1 == n2) && (n3 + n5)%2 == n7) {
//                n1 = 0;
//                n2 = 0;
//            } else if (!(n1 == n2)) {
//                n1 = 1;
//                n2 = 1;
//            } else if (!(n3 == n4) && (n1 + n5)%2 == n7) {
//                n3 = 0;
//                n4 = 0;
//            } else if (!(n3 == n4)) {
//                n3 = 1;
//                n4 = 1;
//            } else if ((n1 + n3)%2 == n7) {
//                n5 = 0;
//                n6 = 0;
//            } else {
//                n5 = 1;
//                n6 = 1;
//            }
//
//            String x = String.format("%s%s%s%s%s%s%s%s", n1, n2, n3, n4, n5, n6, n7, n7);
//            ss.append(x);
//            tab3[i] = ss.toString();
//
//
//            String x1 = String.format("%s%s%s", n1, n3, n5);
//            str.append(x1);
//        }
//
//        //System.out.println(str);
//
//        //iloœæ liczb binarnych, która wyjdzie po podzieleniu
//        int amountBinNum = str.length() / 8;
//
//        //ile bêdzie znaków w ostatnim elemencie tabeli:
//        int lastEl = str.length() % 8;
//
//        if (lastEl == 0) {
//            decodedTab = new String[amountBinNum];
//            tab4 = new String[decodedTab.length];
//            tab5 = new String[tab4.length];
//
//            //podzia³ str na czêsci po 8 el
//            for (int i = 0; i < decodedTab.length; i++) {
//                decodedTab[i] = str.substring((i * 8), 8+(i*8));
//                tab4[i] = decodedTab[i];
//                tab5[i] = Integer.toHexString(Integer.parseInt(tab4[i], 2)).toUpperCase();
//
//                //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
//                if (tab5[i].length() == 1) {
//                    tab5[i] = "0" + tab5[i];
//                }
//            }
//
//        } else {
//            decodedTab = new String[amountBinNum + 1];
//            tab4 = new String[decodedTab.length - 1];
//            tab5 = new String[tab4.length];
//
//            for (int i = 0; i < decodedTab.length; i++) {
//                if (i == decodedTab.length - 1) {
//                    decodedTab[i] = str.substring(8*i);
//                } else {
//                    decodedTab[i] = str.substring((i * 8), 8+(i*8));
//                    tab4[i] = decodedTab[i];
//                    tab5[i] = Integer.toHexString(Integer.parseInt(tab4[i], 2)).toUpperCase();
//
//                    //je¿eli liczba hex ma 1 znak (pomin¹³ zero) to dodaj zero
//                    if (tab5[i].length() == 1) {
//                        tab5[i] = "0" + tab5[i];
//                    }
//
//                }
//            }
//        }
//
//
//        StringBuilder finalText = new StringBuilder();
//        for (int i = 0; i < tab5.length; i++) {
//            finalText.append((char)Integer.parseInt(tab5[i], 16));
//        }
//
//
//
//
//
//        //zapisanie danych do pliku
//        try (FileWriter fileWriter = new FileWriter(decodedFile)) {
//            fileWriter.write(finalText.toString());
//        }catch (IOException e) {
//            System.out.println("File not found:");
//        }
//
//
//
//
//
//
//
//
//        //Wyœwietl informacje w konsoli:
//        System.out.printf("%s:\n", receivedPath);
//        System.out.printf("hex view: %s\n", stringTab(tab2));
//        System.out.printf("bin view: %s\n", stringTab(tab1));
//
//        System.out.println();
//
//        System.out.printf("%s:\n", decodedPath);
//        System.out.printf("correct: %s\n", stringTab(tab3));
//        System.out.printf("decode: %s\n", stringTab(decodedTab));
//        System.out.printf("remove: %s\n", stringTab(tab4));
//        System.out.printf("hex view: %s\n", stringTab(tab5));
//        System.out.printf("text view: %s\n", finalText);
//    }
//
//    public static String stringTab(String[] tab) {
//        return Arrays.toString(tab)
//                .replace("[", "")
//                .replace("]", "")
//                .replace(",", "");
//    }
//
//    public static String stringTabToFile(String[] tab) {
//        return Arrays.toString(tab)
//                .replace("[", "")
//                .replace("]", "")
//                .replace(", ", "");
//    }
//
//}
















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