package Zad_50_Serializacja2;

import Zad_50_Serializacja2.models.OnlineShop;

import java.io.File;

class CustomerTest {
    public static void main(String[] args) {

        File file = new File("src/Zad_50_Serializacja2/clients.csv");

        OnlineShop onlineShop = new OnlineShop(file);
        onlineShop.printMostExpensiveCustomer();
        onlineShop.printCustomersWithCountry();

    }

}
