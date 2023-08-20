package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private final Printer printer = new Printer();


    private static final Scanner scanner = new Scanner(System.in);
    private static double balance = 0.00;
    static Map<Integer, TypesOfProducts> map = new HashMap<>();
    static TypesOfProducts products;
    static String filePath = "purchases.txt";
    //static String filePath = "F:\\1. S  T  U  D  I  A\\�wiczenia z programowania\\Java\\Budget Manager\\Budget Manager\\task\\src\\budget\\purchases.txt";

    public static void main(String[] args) {
        play();
    }
    public static void play() {
        //add default values to the HashMap:
        TypesOfProducts.createHashMap();
        String action;
        do {
            displayMenu();
            action = scanner.nextLine();
            switch (action) {
                case "0" -> exit();
                case "1" -> addIncome();
                case "2" -> addPurchase();
                case "3" -> showListOfPurchases();
                case "4" -> showBalance();
                case "5" -> saveFile();
                case "6" -> loadFile();
                case "7" -> analyze();
                default -> System.out.println(Message.INCORRECT_INPUT);
            }
        } while (action != Option.EXIT);
    }

    private void exit() {
        printer.println(Message.EXIT);
    }

    //      Poka� menu g��wne:

//      Poka� podmenu nr 1:
    public static void showTypesOfPurchases1() {
        for (Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
            if(el.getValue().equals(TypesOfProducts.ALL)) return;
            System.out.printf("%d) %s\n", el.getKey(), el.getValue().getName());
        }
    }
//      Poka� podmenu nr 2:
    public static void showTypesOfPurchases2() {
        System.out.println("\nChoose the type of purchase");
        showTypesOfPurchases1();
        System.out.printf("%d) Back\n", map.size());
    }
//      Poka� podmenu nr 3:
    public static void showTypesOfPurchases3() {
        System.out.println("\nChoose the type of purchases");
        showTypesOfPurchases1();
        System.out.printf("%d) All\n", map.size());
        System.out.printf("%d) Back\n", map.size()+1);
    }
//      Poka� podmenu nr 4:
    public static void showSortTypes() {
        System.out.println("\nHow do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }

//      1) Dodaj przych�d:
    public static void addIncome() {
        double income;
        while(true) {
            System.out.println("\nEnter income:");
            try {
                income = Double.parseDouble(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException ignored) {
            }
        }
        balance += income;
        System.out.println("Income was added!");
    }
//      2) Dodaj wydatki (zakupy, rozchody):
    public static void addPurchase() {
        double price;

        while(true) {
            int typeOfPurchase;
            while(true) {
                showTypesOfPurchases2();
                try {
                    //wybierz numer pozycji menu
                    typeOfPurchase = Integer.parseInt(scanner.nextLine());

                    //if zale�ny od rozmiaru mapy, poniewa� ilo�� pozycji menu powinna by� uzale�niona od zawarto�ci mapy
                    if (typeOfPurchase > 0 && typeOfPurchase < map.size()) {
                        break;
                    } else if (typeOfPurchase == 5) {
                        return;
                    } else {
                        System.out.println("\nEnter numbers. Try again!");
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("\nEnter numbers. Try again!");
                }
            }

            String x;
            while(true) {
                System.out.println("\nEnter purchase name:");
                x = scanner.nextLine();
                if(!x.isEmpty() && !x.isBlank()) break;
            }

            while (true) {
                System.out.println("Enter its price:");
                try {

                    price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Purchase was added!");
                    break;
                } catch (InputMismatchException | NumberFormatException ignored){}
            }

            //we� dan� kategori� z mapy:
            products = map.get(typeOfPurchase);

            //we� dan� list� tej kategorii
            ArrayList<String> list = products.getBoughtProducts();

            //zmie� sum� w tej kategorii
            products.setSum(products.getSum() + price);

            //dodaj zakupione rzeczy do listy w tej kategorii
            list.add(String.format("%s $%.2f", x, price));

            //dodaj t� rzecz r�wnie� do listy wszystkich zakupionych rzeczy:
            map.get(5).getBoughtProducts().add(String.format("%s $%.2f", x, price));
            map.get(5).setSum(map.get(5).getSum() + price);

            //zmie� stan konta:
            balance -= price;
        }
    }
//      3) Pokaz list� wydatk�w (zakup�w, rozchod�w):
    public static void showListOfPurchases() {
        while(true) {
            if (map.get(5).getBoughtProducts().size() == 0) {
                System.out.println("\nThe purchase list is empty!");
                return;
            }

            int choice;
            while(true) {
                try {
                    //wy�wietl menu
                    showTypesOfPurchases3();
                    choice = Integer.parseInt(scanner.nextLine());

                    if (choice > 0 && choice <= map.size()) {
                        break;
                    } else if (choice == 6) {
                        return;
                    }
                } catch (InputMismatchException | NumberFormatException ignored) {
                }
            }

            //rozmiar listy danej kategorii
            int vol = map.get(choice).getBoughtProducts().size();
            ArrayList<String> list = map.get(choice).getBoughtProducts();
            double sum = map.get(choice).getSum();

            System.out.printf("\n%s:", map.get(choice).getName());
            if (vol == 0) {
                System.out.println("\nThe purchase list is empty!");

            } else {
                System.out.println();
                list.forEach(System.out::println);
                System.out.printf("Total sum: $%.2f\n", sum);
            }
        }
    }
//      4) Poka� stan konta:
    public static void showBalance() {
        System.out.printf("\nBalance: $%.2f\n", balance);
    }
//      5) Zapisz dane do pliku tekstowego:
    public static void saveFile() {
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(String.format("Balance: $%.2f\n\n", balance));

            for(Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
                int num = el.getKey();

                String nameOfCategory = el.getValue().getName();
                double sumOfCategory = el.getValue().getSum();
                ArrayList<String> list = el.getValue().getBoughtProducts();

                StringBuilder sb = new StringBuilder();

                if (list.size() == 0) {
                    String t = "\tThe purchase list is empty!\n";
                    sb = new StringBuilder(t);
                } else {
                    for (String pos : list) {

                        int indexLast$ = pos.lastIndexOf("$");

                        String name = pos.substring(0,indexLast$);
                        String price = pos.substring(indexLast$ + 1);
                        String designOfPos = String.format("\t- %40s $%s\n", name, price);
                        sb.append(designOfPos);
                    }
                }

                String listOfPurchases = sb.toString();

                String text = String.format(
                        "%d %s:"     +"\n"+
                        "%s"         +
                        "--------------------------------------------------------\n" +
                        "\t%41s  $%.2f\n\n"
                , num, nameOfCategory,listOfPurchases,"TOTAL:", sumOfCategory);
                writer.write(text);
            }

            System.out.println("\nPurchases were saved!");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
//      6) Pobierz dane z pliku tekstowego:
    public static void loadFile() {
        File file = new File(filePath);
        try (Scanner importScanner = new Scanner(file)) {

            //ustawienie stanu konta:
            String[] temp = importScanner.nextLine().split("\\$");

            if (temp[1].contains(",")) {
                balance = Double.parseDouble(temp[1].replace(",", "."));
            } else {
                balance = Double.parseDouble(temp[1]);
            }

            importScanner.nextLine();

            while(importScanner.hasNextLine()) {
                //linijka z numerem i nazw�
                String[] temp1 = importScanner.nextLine().split("\\s+");
                temp1[1] = temp1[1].replace(":", "");
                int numOfCat = Integer.parseInt(temp1[0]);
                double price;
                String name;
                double sum;

                String firstLine = importScanner.nextLine();

                //je�eli dana kategoria jest pusta to id� do nast�pnej
                if (!firstLine.equals("\tThe purchase list is empty!")) {
                    //p�tla do stworzenia listy
                    while (true) {
                        if (firstLine.startsWith("\t-")) {
                            //ostatnie wyst�pienie $ oznacza pocz�tek ceny:
                            int indexLast$ = firstLine.lastIndexOf("$");

                            String reallyPrice = firstLine.substring(indexLast$ + 1);
                            String reallyName = firstLine.substring(0, indexLast$);

                            //ca�a linijka podzielona na cz�� nazwy i cz�� ceny
                            //String[] temp3 = firstLine.split("\\$");

                            //pozbawinie nazwy zb�dnych spacji
                            String[] nameWithoutSpaces = reallyName.trim().split("\\s+");

                            //cena pojedynczego produktu
                            if (reallyPrice.contains(",")) {
                                price = Double.parseDouble(reallyPrice.replace(",", "."));
                            } else {
                                price = Double.parseDouble(reallyPrice);
                            }

                            StringBuilder nameSB = new StringBuilder();
                            for (String s : nameWithoutSpaces) {
                                nameSB.append(String.format("%s ", s));
                            }

                            //nowa linijka usuni�cie pocz�tkowych my�lnik�w i dodatkowej spacji:
                            nameSB.deleteCharAt(0);
                            nameSB.deleteCharAt(0);

                            //nowa ca�a linijka (bez zb�dnych tab�w i spacji)
                            nameSB.append(String.format("$%.2f", price));
                            name = nameSB.toString();

                            //aktualizacja pierwszej linijki:
                            firstLine = importScanner.nextLine();

                            //dodaj pozycj� do listy
                            map.get(numOfCat).getBoughtProducts().add(name);
                        } else {
                            break;
                        }
                    }
                    String[] temp5 = importScanner.nextLine().split("\\$");
                    sum = Double.parseDouble(temp5[1].replace(",", "."));

                    //ustaw sum� kategorii
                    map.get(numOfCat).setSum(sum);

                    importScanner.nextLine();
                } else {
                    importScanner.nextLine();
                    importScanner.nextLine();
                    importScanner.nextLine();
                }
            }
            System.out.println("\nPurchases were loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
//      7) Sortuj wybrane dane:
    public static void analyze() {
        while(true) {
            showSortTypes();
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    sortAllPurchases();
                    break;
                case "2":
                    sortByType();
                    break;
                case "3":
                    sortCertainType();
                    break;
                case "4":
                    return;
                default:
                    break;
            }
        }
    }

//      Poka� list� wszystkich wydatk�w, posortowan� malej�co
    public static void sortAllPurchases() {
        ArrayList<String> allList = map.get(5).getBoughtProducts();
        sortingDesc(allList, map.get(5).getSum(), map.get(5).getName());
    }
//      Poka� list� kategorii, posortowan� malej�co
    public static void sortByType() {
        SortedMap<Double, String> sortedMap = new TreeMap<>(Collections.reverseOrder());

        if (map.get(5).getSum() == 0) {
            System.out.println("\nTypes:");
            for (Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
                if(el.getValue().equals(TypesOfProducts.ALL)) {
                    System.out.printf("Total sum: $%.0f\n", el.getValue().getSum());
                    break;
                }
                System.out.printf("%s - $%.0f\n", el.getValue().getName(), el.getValue().getSum());
            }
            return;
        }

        for (Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
            sortedMap.put(el.getValue().getSum(), el.getValue().getName() + " - $");
        }

        String temp = "";
        System.out.println("\nTypes:");
        for (Map.Entry<Double, String> sortEl : sortedMap.entrySet()) {
            if (sortEl.getValue().equals(TypesOfProducts.ALL.getName() + " - $")) {
                temp = "Total sum: $" + sortEl.getKey();
                continue;
            }
            System.out.println(sortEl.getValue() + sortEl.getKey());
        }
        System.out.println(temp);
    }
//      Poka� list� wydatk�w danej kategorii, posortowan� malej�co
    public static void sortCertainType() {
        System.out.println("\nChoose the type of purchase");
        showTypesOfPurchases1();
        while (true) {
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    TypesOfProducts el = map.get(1);
                    sortingDesc(el.getBoughtProducts(), el.getSum(), el.getName());
                    return;
                case "2":
                    TypesOfProducts el1 = map.get(2);
                    sortingDesc(el1.getBoughtProducts(), el1.getSum(), el1.getName());
                    return;
                case "3":
                    TypesOfProducts el2 = map.get(3);
                    sortingDesc(el2.getBoughtProducts(), el2.getSum(), el2.getName());
                    return;
                case "4":
                    TypesOfProducts el3 = map.get(4);
                    sortingDesc(el3.getBoughtProducts(), el3.getSum(), el3.getName());
                    return;
                default:
                    break;
            }
        }
    }

//      Wy�wietlanie zawarto�ci tablicy w kolejno�ci malej�cej
    public static void sortingDesc (ArrayList<String> list, double total, String name) {
        //je�eli lista pusta to wy�wietl komunikat i wyjd�
        if (list.isEmpty()) {
            System.out.println("\nThe purchase list is empty!");
            return;
        } else if (list.size() == 1) {
            System.out.println(list);
            System.out.printf("Total: $%.2f\n", total);
            return;
        }

        // --- BUBLE SORT
        //je�eli lista posiada min. 2 elementy to wykonaj sortowanie
        for (int i = 0; i < list.size() - 1; i++ ) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                String el1 = list.get(j);
                String el2 = list.get(j+1);
                String p1 = el1.substring(el1.lastIndexOf("$") + 1);
                String p2 = el2.substring(el2.lastIndexOf("$") + 1);

                if (p1.contains(",")) p1 = p1.replace(",", ".");
                if (p2.contains(",")) p2 = p2.replace(",", ".");

                double price1 = Double.parseDouble(p1);
                double price2 = Double.parseDouble(p2);

                //TO SORT IN ASCENDING ORDER, CHANGE < TO >
                if (price1 < price2) {
                    String temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }

        System.out.printf("\n%s:\n", name);
        list.forEach(System.out::println);
        System.out.printf("Total sum: $%.2f\n", total);
    }


}
