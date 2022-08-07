package budget;

import java.io.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 0.00;
    static Map<Integer, TypesOfProducts> map = new HashMap<>();
    static TypesOfProducts products;
    static String filePath = "purchases.txt";
    //static String filePath = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Budget Manager\\Budget Manager\\task\\src\\budget\\purchases.txt";


    public static void main(String[] args) {
        play();
    }

    public static void play() {
        //add default values to the HashMap:
        TypesOfProducts.createHashMap();

        while(true) {
            displayMenu();
            String action = scanner.nextLine();
            switch (action) {
                case "0":
                    System.out.println("\nBye!");
                    return;
                case "1":
                    addIncome();
                    break;
                case "2":
                    addPurchase();
                    break;
                case "3":
                    showListOfPurchases();
                    break;
                case "4":
                    showBalance();
                    break;
                case "5":
                    saveFile();
                    break;
                case "6":
                    loadFile();
                    break;
                default:
                    System.out.println("\nIncorrect operation. Try again!");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\nChoose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("0) Exit");
    }

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
    public static void addPurchase() {
        double price;

        while(true) {




            int typeOfPurchase;
            while(true) {
                showTypesOfPurchases1();
                try {
                    //wybierz numer pozycji menu
                    typeOfPurchase = Integer.parseInt(scanner.nextLine());

                    //if zale¿ny od rozmiaru mapy, poniewa¿ iloœæ pozycji menu powinna byæ uzale¿niona od zawartoœci mapy
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

            //weŸ dan¹ kategoriê z mapy:
            products = map.get(typeOfPurchase);

            //weŸ dan¹ listê tej kategorii
            ArrayList<String> list = products.getBoughtProducts();

            //zmieñ sumê w tej kategorii
            products.setSum(products.getSum() + price);

            //dodaj zakupione rzeczy do listy w tej kategorii
            list.add(String.format("%s $%.2f", x, price));

            //dodaj tê rzecz równie¿ do listy wszystkich zakupionych rzeczy:
            map.get(5).getBoughtProducts().add(String.format("%s $%.2f", x, price));
            map.get(5).setSum(map.get(5).getSum() + price);

            //zmieñ stan konta:
            //double sumAll = map.get(5).getSum();
            balance -= price;

        }
    }


    public static void showListOfPurchases() {
        while(true) {
            if (map.get(5).getBoughtProducts().size() == 0) {
                System.out.println("\nThe purchase list is empty!");
                return;
            }


            int choice;
            while(true) {
                try {
                    //wyœwietl menu
                    showTypesOfPurchases2();
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
    public static void showBalance() {

        System.out.printf("\nBalance: $%.2f\n", balance);
    }
    public static void showTypesOfPurchases1() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }
    public static void showTypesOfPurchases2() {
        System.out.println("\nChoose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
    }

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
                //linijka z numerem i nazw¹
                String[] temp1 = importScanner.nextLine().split("\\s+");
                temp1[1] = temp1[1].replace(":", "");
                int numOfCat = Integer.parseInt(temp1[0]);

                double price;
                String name;
                double sum;

                String firstLine = importScanner.nextLine();
                //System.out.println("Poza ifem :" + importScanner.nextLine());


                //je¿eli dana kategoria jest pusta to idŸ do nastêpnej
                if (!firstLine.equals("\tThe purchase list is empty!")) {



                    //pêtla do stworzenia listy
                    while (true) {
                        //ca³a linijka
                       // String wholeLine = importScanner.nextLine();

                        if (firstLine.startsWith("\t-")) {

                            //ostatnie wyst¹pienie $ oznacza pocz¹tek ceny:
                            int indexLast$ = firstLine.lastIndexOf("$");

                            String reallyPrice = firstLine.substring(indexLast$ + 1);
                            String reallyName = firstLine.substring(0, indexLast$);

                            //ca³a linijka podzielona na czêœæ nazwy i czêœæ ceny
                            //String[] temp3 = firstLine.split("\\$");

                            //pozbawinie nazwy zbêdnych spacji
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


                            //nowa linijka usuniêcie pocz¹tkowych myœlników i dodatkowej spacji:
                            nameSB.deleteCharAt(0);
                            nameSB.deleteCharAt(0);


                            //nowa ca³a linijka (bez zbêdnych tabów i spacji)
                            nameSB.append(String.format("$%.2f", price));
                            name = nameSB.toString();




                            //aktualizacja pierwszej linijki:
                            firstLine = importScanner.nextLine();





                            //dodaj pozycjê do listy
                            map.get(numOfCat).getBoughtProducts().add(name);
                        } else {
                            break;
                        }
                    }
                    String[] temp5 = importScanner.nextLine().split("\\$");
                    sum = Double.parseDouble(temp5[1].replace(",", "."));

                    //ustaw sumê kategorii
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
}
