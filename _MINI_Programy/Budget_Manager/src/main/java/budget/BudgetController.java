package budget;

import java.util.*;

import static budget.Option.*;

public class BudgetController {
    private final Printer printer = new Printer();
    private final DataReader reader = new DataReader(printer);
    private final Sorter sorter = new Sorter();

    private double balance = 0.00;
    private final Map<Integer, TypesOfProducts> map = new HashMap<>();
    static TypesOfProducts products;
    //static String filePath = "F:\\1. S  T  U  D  I  A\\�wiczenia z programowania\\Java\\Budget Manager\\Budget Manager\\task\\src\\budget\\purchases.txt";

    public void mainLoop() {
        TypesOfProducts.createHashMap(map);
        Option option;
        do {
            printer.displayMenu();
            option = reader.getOptionFromInt();
            switch (option) {
                case EXIT -> exit();
                case ADD_INCOME -> addIncome();
                case ADD_PURCHASE -> addPurchase();
                case SHOW_PURCHASES -> showListOfPurchases();
                case BALANCE -> showBalance();
                case SAVE -> saveFile();
                case LOAD -> loadFile();
                case ANALYZE -> analyze();
                default -> System.out.println(Message.INCORRECT_INPUT);
            }
        } while (option != EXIT);
    }

    private void exit() {
        printer.println(Message.EXIT);
    }

    private void saveFile() {
        reader.saveFile(balance, map);
    }

    private void loadFile() {
        reader.loadFile(balance, map);
    }

//      Poka� podmenu nr 1:
    public void showTypesOfPurchases() {
        for (Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
            if(el.getValue().equals(TypesOfProducts.ALL)) return;
            System.out.printf("%d) %s\n", el.getKey(), el.getValue().getName());
        }
    }
//      Poka� podmenu nr 2:
    public void showTypesOfPurchases2() {
        System.out.println("\nChoose the type of purchase");
        showTypesOfPurchases();
        System.out.printf("%d) Back\n", map.size());
    }
//      Poka� podmenu nr 3:
    public void showTypesOfPurchases3() {
        System.out.println("\nChoose the type of purchases");
        showTypesOfPurchases();
        System.out.printf("%d) All\n", map.size());
        System.out.printf("%d) Back\n", map.size()+1);
    }

    public void showSortTypes() {
        printer.showSortTypes();
    }

    public void addIncome() {
        double income = 0.0;
        boolean incomeOK = false;
        do {
            printer.println(Message.ADD_INCOME);
            try {
                income = reader.getDouble();
                incomeOK = true;
            } catch (IllegalArgumentException e) {
                printer.println(Message.INCORRECT_VALUE);
            }
        } while (!incomeOK);
        balance += income;
        printer.println(Message.INCOME_ADDED);
    }
//      2) Dodaj wydatki (zakupy, rozchody):
    public void addPurchase() {
        double price;

        while(true) {
            int typeOfPurchase;
            while(true) {
                showTypesOfPurchases2();
                try {
                    //wybierz numer pozycji menu
                    typeOfPurchase = Integer.parseInt(reader.getString());

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
                x = reader.getString();
                if(!x.isEmpty() && !x.isBlank()) break;
            }

            while (true) {
                System.out.println("Enter its price:");
                try {

                    price = Double.parseDouble(reader.getString());

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
    public void showListOfPurchases() {
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
                    choice = Integer.parseInt(reader.getString());

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
    public void showBalance() {
        printer.printf("\nBalance: $%.2f\n", balance);
    }


//      7) Sortuj wybrane dane:
    public void analyze() {
        String action;
        do {
            showSortTypes();
            action = reader.getString();
            switch (action) {
                case "1" -> sortAllPurchases();
                case "2" -> sortByType();
                case "3" -> sortCertainType();
                default -> {
                }
            }
        } while (!action.equals("4"));
    }

//      Poka� list� wszystkich wydatk�w, posortowan� malej�co
    public void sortAllPurchases() {
        ArrayList<String> allList = map.get(5).getBoughtProducts();
        sortingDesc(allList, map.get(5).getSum(), map.get(5).getName());
    }
//      Poka� list� kategorii, posortowan� malej�co
    public void sortByType() {
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
    public void sortCertainType() {
        printer.println("\nChoose the type of purchase");
        showTypesOfPurchases();
        while (true) {
            String action = reader.getString();
            switch (action) {
                case "1" -> {
                    TypesOfProducts el = map.get(1);
                    sortingDesc(el.getBoughtProducts(), el.getSum(), el.getName());
                    return;
                }
                case "2" -> {
                    TypesOfProducts el1 = map.get(2);
                    sortingDesc(el1.getBoughtProducts(), el1.getSum(), el1.getName());
                    return;
                }
                case "3" -> {
                    TypesOfProducts el2 = map.get(3);
                    sortingDesc(el2.getBoughtProducts(), el2.getSum(), el2.getName());
                    return;
                }
                case "4" -> {
                    TypesOfProducts el3 = map.get(4);
                    sortingDesc(el3.getBoughtProducts(), el3.getSum(), el3.getName());
                    return;
                }
                default -> {
                }
            }
        }
    }

//      Wy�wietlanie zawarto�ci tablicy w kolejno�ci malej�cej
    public void sortingDesc (ArrayList<String> list, double total, String name) {
        //je�eli lista pusta to wy�wietl komunikat i wyjd�
        if (list.isEmpty()) {
            printer.println("\nThe purchase list is empty!");
            return;
        } else if (list.size() == 1) {
            printer.println(list);
            printer.printf("Total: $%.2f\n", total);
            return;
        }

        sorter.doBubbleSort(list);

        printer.printf("\n%s:\n", name);
        list.forEach(System.out::println);
        printer.printf("Total sum: $%.2f\n", total);
    }


}
