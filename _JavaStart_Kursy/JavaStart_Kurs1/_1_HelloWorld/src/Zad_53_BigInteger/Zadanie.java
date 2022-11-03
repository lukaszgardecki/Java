package Zad_53_BigInteger;

import java.io.*;
import java.math.BigInteger;

class Zadanie {
    public static void main(String[] args) {
        File file = new File("src/Zad_53_BigInteger/input.txt");
        int n1, n2, n3;
        BigInteger big1, big2;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            n1 = Integer.parseInt(br.readLine());
            n2 = Integer.parseInt(br.readLine());
            n3 = Integer.parseInt(br.readLine());
            big1 = new BigInteger(br.readLine());
            big2 = new BigInteger(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Wynik dodawania trzech pierwszych liczb: " + (n1 + n2 + n3));
        System.out.println("Wynik dodawania dwóch ostatnich liczb: " + big1.add(big2));
    }
}
