package Zad_50_Serializacja2.models;

import Zad_50_Serializacja2.io.MyCustomerReader;

import java.io.File;

public class OnlineShop {
    private Customer[] customers;
    private int addedCustomers = 0;
    private MyCustomerReader reader;


    public OnlineShop(File file) {
        reader = new MyCustomerReader(file);
        customers = new Customer[reader.getNumOfCustomers()];
        reader.read(this);

    }

    public void add(Customer customer) {
        customers[addedCustomers] = customer;
        addedCustomers++;
    }

    Customer getMostExpensiveCustomer() {
        Customer c = customers[0];
        for (Customer customer : customers) {
            if (customer.getValue() > c.getValue()) {
                c = customer;
            }
        }
        return c;
    }

    public void printCustomersWithCountry() {
        String userCountry = reader.getCountryFromUser();
        reader.printLine(String.format("Klienci z kraju %s:", userCountry));
        int printedCustomers = 0;
        double totalValueOfPrintedCustomers = 0;

        for (Customer customer : customers) {
            if (customer.getCountry().equals(userCountry)) {
                reader.printLine(customer.toString());
                printedCustomers++;
                totalValueOfPrintedCustomers += customer.getValue();
            }
        }

        if (printedCustomers == 0) {
            reader.printLine("Brak wyników wyszukiwania.");
        } else {
            reader.printLine(
                    String.format("Œrednia wartoœæ klienta z %s to %.2fz³",
                        userCountry, (totalValueOfPrintedCustomers/printedCustomers)
                    )
            );
        }
    }



    public void printMostExpensiveCustomer() {
        reader.printLine("Najbardziej wartoœciowy klient to " + getMostExpensiveCustomer());
    }
}
