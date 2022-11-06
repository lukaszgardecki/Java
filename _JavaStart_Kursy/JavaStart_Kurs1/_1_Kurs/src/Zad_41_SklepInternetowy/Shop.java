package Zad_41_SklepInternetowy;

import java.util.Scanner;

class Shop {
    public static void main(String[] args) {
        Order[] orders = createOrders();
        String input = readStatus();
        Order[] ordersWithStatus = getOrders(orders, input);
        printOrders(ordersWithStatus);
    }

    private static String readStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Podaj status zamówieñ do wyœwietlenia (%s):\n", Status.getStatuses());
        String input = scanner.nextLine();
        System.out.println("Lista zamówieñ ze statusem " + input + ":");
        return input;
    }

    private static void printOrders(Order[] ordersWithStatus) {
        for (Order order : ordersWithStatus) {
            if (order != null) {
                System.out.println(order); ;
            }
        }
    }

    private static Order[] createOrders() {
        return new Order[] {
                new Order("Komputer Apple MacBook Pro 2018", 4999.0, Status.DELIVERED),
                new Order("Termos h=30cm", 45.3, Status.DELIVERED),
                new Order("Telefon Apple iPhone X", 2999.0, Status.DELIVERED),
                new Order("Adapter USBC - HDMI", 149.0, Status.SHIPPED),
                new Order("Mysz komputerowa zajebista", 250.49, Status.DELIVERED),
                new Order("Klawiatura komputerowa z koœci s³oniowej", 20500.4, Status.NEW),
                new Order("Monitor milion cali MAKBUK", 25.90, Status.DELIVERED),
                new Order("Kebab w cieœcie, baranina, sos mieszany", 23.0, Status.NEW),
        };
    }

    private static Order[] getOrders(Order[] orders, String input) {
        for (Status status : Status.values()) {
            if (status.name().equals(input.toUpperCase())) {
                return get(orders, status);
            }
        }
        return null;
    }

    private static Order[] get(Order[] orders, Status status) {
        int addedEl = 0;
        Order[] ordersWithStatus = new Order[orders.length];

        for (Order order : orders) {
            if (order.getStatus().name().equals(status.name())) {
                ordersWithStatus[addedEl] = order;
                addedEl++;
            }
        }

        if (addedEl == 0) {
            System.out.println("Brak zamówieñ z takim statusem.");
        }
        return ordersWithStatus;
    }


}
