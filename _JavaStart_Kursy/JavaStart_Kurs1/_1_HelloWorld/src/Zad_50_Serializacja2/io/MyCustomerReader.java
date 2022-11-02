package Zad_50_Serializacja2.io;

import Zad_50_Serializacja2.models.Customer;
import Zad_50_Serializacja2.models.OnlineShop;

import java.io.*;
import java.util.Scanner;

public class MyCustomerReader {
    private File file;

    public MyCustomerReader(File file) {
        this.file = file;
    }

    public void read(OnlineShop shop) {
        try (FileReader fr = new FileReader(file);
             BufferedReader bReader = new BufferedReader(fr)) {

            String line;
            bReader.readLine();

            while ((line = bReader.readLine()) != null) {
                String[] temp = line.split(",");
                shop.add(new Customer(
                        Integer.parseInt(temp[0]),
                        temp[1],
                        temp[2],
                        temp[3],
                        Double.parseDouble(temp[4])
                ));
            }
        } catch (IOException e) {
            printLine("Nie uda³o siê odczytaæ pliku.");
        }
    }

    public int getNumOfCustomers() {
        int num = 0;
        try (FileReader fr = new FileReader(file);
             BufferedReader bReader = new BufferedReader(fr)) {

            bReader.readLine();

            while (bReader.readLine() != null) {
                num++;
            }
        } catch (IOException e) {
            printLine("Nie uda³o siê odczytaæ pliku.");
        }
        return num;
    }

    public void printLine(String text) {
        System.out.println(text);
    }


    public String getCountryFromUser() {
        printLine("Podaj nazwê kraju, z którego klienci Ciê interesuj¹:");
        return new Scanner(System.in).nextLine();
    }
}
