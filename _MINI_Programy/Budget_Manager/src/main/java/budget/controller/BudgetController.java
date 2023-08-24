package budget.controller;

import budget.helper.Sorter;
import budget.io.DataReader;
import budget.io.DataWriter;
import budget.io.Message;
import budget.io.Printer;
import budget.model.Budget;
import budget.model.Option;
import budget.model.Product;
import budget.model.ProductType;

import java.util.*;

import static budget.model.Option.EXIT;

public class BudgetController {
    private final Printer printer;
    private final DataReader reader;
    private final DataWriter writer;
    private final Sorter sorter;
    private final Budget budget;

    public BudgetController(Budget budget) {
        this.printer = new Printer();
        this.reader = new DataReader(printer);
        this.writer = new DataWriter(printer);
        this.sorter = new Sorter();
        this.budget = budget;
    }

    public void mainLoop() {
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
                case SAVE -> saveBudget();
                case LOAD -> loadBudget();
                case ANALYZE -> analyze();
                default -> System.out.println(Message.INCORRECT_INPUT);
            }
        } while (option != EXIT);
    }

//      Poka� podmenu nr 1:
    private void showTypesOfPurchases() {
        budget.getTypeList().forEach(printer::println);
    }

//      Poka� podmenu nr 3:
    private void showTypesOfPurchases2() {
        printer.println("\nChoose the type of purchases");
        showTypesOfPurchases();
        printer.printf("%d) Back\n", budget.getTypeList().size()+1);
    }

    private void showSortTypes() {
        printer.showSortTypes();
    }

    private void addIncome() {
        double income = reader.getIncome();
        budget.addIncome(income);
        printer.println(Message.INCOME_ADDED);
    }
    private void addPurchase() {
        ProductType productType = reader.getProductTypeFromInt();
        String purchaseName = reader.getPurchaseName();
        double purchasePrice = reader.getPurchasePrice();
        Product product = new Product(purchaseName, purchasePrice, productType);
        budget.addNewPurchase(product);
    }
//      3) Pokaz list� wydatk�w (zakup�w, rozchod�w):
    private void showListOfPurchases() {
        printer.printAllBoughtProductsFrom(budget);
    }

    private void showBalance() {
        printer.printf("\nBalance: $%.2f\n", budget.getBalance());
    }


//      7) Sortuj wybrane dane:
    private void analyze() {
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
    private void sortAllPurchases() {
        sortingDesc(budget.getProductType(ProductType.ALL));
    }
//      Poka� list� kategorii, posortowan� malej�co
    private void sortByType() {
        SortedMap<Double, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        printer.println("\nTypes:");

        if (budget.getProductType(ProductType.ALL).getTotalSum() == 0) {
            for (ProductType el : budget.getTypeList()) {
                if(el.equals(ProductType.ALL)) {
                    printer.printf("Total sum: $%.0f\n", el.getTotalSum());
                    break;
                }
                printer.printf("%s - $%.0f\n", el.getName(), el.getTotalSum());
            }
            return;
        }

        for (ProductType el : budget.getTypeList()) {
            sortedMap.put(el.getTotalSum(), el.getName() + " - $");
        }

        String temp = "";
        for (Map.Entry<Double, String> sortEl : sortedMap.entrySet()) {
            if (sortEl.getValue().equals(ProductType.ALL.getName() + " - $")) {
                temp = "Total sum: $" + sortEl.getKey();
                continue;
            }
            printer.println(sortEl.getValue() + sortEl.getKey());
        }
        printer.println(temp);
    }

//      Poka� list� wydatk�w danej kategorii, posortowan� malej�co
    private void sortCertainType() {
        printer.println("\nChoose the type of purchase");
        showTypesOfPurchases();
        ProductType type = reader.getProductTypeFromInt();
        switch (type) {
            case FOOD -> sortingDesc(budget.getProductType(ProductType.FOOD));
            case CLOTHES -> sortingDesc(budget.getProductType(ProductType.CLOTHES));
            case ENTERTAINMENT -> sortingDesc(budget.getProductType(ProductType.ENTERTAINMENT));
            case OTHER -> sortingDesc(budget.getProductType(ProductType.OTHER));
            default -> sortingDesc(budget.getProductType(ProductType.ALL));
        }
    }

//      Wy�wietlanie zawarto�ci tablicy w kolejno�ci malej�cej
    private void sortingDesc(ProductType type) {
        List<Product> list = type.getBoughtProducts();

        //je�eli lista pusta to wy�wietl komunikat i wyjd�
        if (list.isEmpty()) {
            printer.println(Message.PURCHASE_LIST_EMPTY);
            return;
        } else if (list.size() == 1) {
            printer.println(list);
            printer.printf("Total: $%.2f\n", type.getTotalSum());
            return;
        }

        sorter.doBubbleSort(list);

        printer.printf("\n%s:\n", type.getName());
        list.forEach(printer::println);
        printer.printf("Total sum: $%.2f\n", type.getTotalSum());
    }

    private void exit() {
        printer.println(Message.EXIT);
    }

    private void saveBudget() {
        writer.save(budget);
    }

    private void loadBudget() {
        reader.load(budget);
    }
}
