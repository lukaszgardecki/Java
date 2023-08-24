package budget.io;

import budget.*;
import budget.model.Budget;
import budget.model.Option;
import budget.model.Product;
import budget.model.ProductType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner;
    private final Scanner importScanner;
    private final Printer printer;
    private final File file;

    public DataReader(Printer printer) {
        this.file = new File(Application.TARGET_FILE_PATH);
        this.printer = printer;
        this.scanner = new Scanner(System.in);
        this.importScanner = createImportScanner();
    }

    public String getString() {
        return scanner.nextLine();
    }

    public int getInt() {
        boolean intOK = false;
        int num = -1;
        do {
            try {
                num = scanner.nextInt();
                if (num < 0) throw new InputMismatchException();
                intOK = true;
            } catch (InputMismatchException e) {
                printer.println(Message.INCORRECT_VALUE);
            } finally {
                scanner.nextLine();
            }
        } while (!intOK);
        return num;
    }

    public double getDouble() {
        try {
            return scanner.nextDouble();
        } finally {
            scanner.nextLine();
        }
    }

    public Option getOptionFromInt() {
        Option option;
        do {
            int enteredValue = getInt();
            option = Arrays.stream(Option.values())
                    .filter(o -> o.getValue() == enteredValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(Message.BAD_OPT_NUM));
        } while (option == null);
        return option;
    }

    public ProductType getProductTypeFromInt() {
        ProductType productType;
        do {
            printer.printProductTypes();
            int enteredValue = getInt();
            productType = Arrays.stream(ProductType.values())
                    .filter(type -> type.getValue() == enteredValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(Message.BAD_OPT_NUM));
        } while (productType == null);
        return productType;
    }


    public void load(Budget budget) {

        double balance = readBalanceFromFile();
        budget.setBalance(balance);

        skipEmptyLines(1);

        while(importScanner.hasNextLine()) {
            String typeName = readProductTypeName();
            String line = importScanner.nextLine();

            //je�eli dana kategoria jest pusta to id� do nast�pnej
            if (line.equals(Message.PURCHASE_LIST_EMPTY)) {
                skipEmptyLines(3);
            } else {
                while (line.startsWith("\t-")) {
                    Product product = readProductFrom(line);
                    product.setProductType(ProductType.valueOf(typeName));
                    loadProductToBudget(product, budget);
                    line = importScanner.nextLine();
                }
                String totalPriceStr = importScanner.nextLine().split("\\$")[1];
                double totalSum = getDoubleFromString(totalPriceStr);

                budget.getTypeList().stream()
                        .filter(t -> t.getName().equals(typeName))
                        .forEach(t -> t.setTotalSum(totalSum));

                skipEmptyLines(1);
            }
        }
       printer.println(Message.LOAD_SUCCESS);
    }

    public String getPurchaseName() {
        String name;
        boolean nameOK = false;
        do {
            printer.println("\nEnter purchase name:");
            name = getString().trim();
            if(!name.isEmpty() && !name.isBlank()) {
                nameOK = true;
            }
        } while (!nameOK);
        return name;
    }

    public double getPurchasePrice() {
        double price = 0.0;
        boolean priceOK = false;
        do {
            printer.println("Enter its price:");
            try {
                price = getDouble();
                priceOK = true;
                printer.println(Message.PURCHASE_ADDED);
            } catch (InputMismatchException | NumberFormatException ignored) {
                printer.println(Message.INCORRECT_VALUE);
            }
        } while (!priceOK);
        return price;
    }

    public double getIncome() {
        double price = 0.0;
        boolean priceOK = false;
        do {
            printer.println(Message.ADD_INCOME);
            try {
                price = getDouble();
                priceOK = true;
                printer.println(Message.PURCHASE_ADDED);
            } catch (InputMismatchException | NumberFormatException ignored) {
                printer.println(Message.INCORRECT_VALUE);
            }
        } while (!priceOK);
        return price;
    }

    private void loadProductToBudget(Product product, Budget budget) {
        ProductType productType = budget.getProductType(product.getType());
        budget.getProductType(productType).addBoughtProduct(product);
    }

    private Product readProductFrom(String line) {
        String productName = readProductNameFrom(line);
        double productPrice = readPriceFrom(line);
        return new Product(productName, productPrice, null);
    }

    private String readProductNameFrom(String line) {
        int sign$index = line.lastIndexOf("$");
        return line.substring(0, sign$index)
                .trim()
                .replaceFirst("-", "")
                .trim();
    }

    private String readProductTypeName() {
        String[] temp1 = importScanner.nextLine().split("\\s+");
        return temp1[1].replace(":", "").toUpperCase();
    }

    private double readPriceFrom(String line) {
        String priceStr = line.substring(line.lastIndexOf("$") + 1);
        return getDoubleFromString(priceStr);
    }

    private void skipEmptyLines(int numOfLines) {
        for (int i = 0; i < numOfLines; i++) {
            importScanner.nextLine();
        }
    }

    private double readBalanceFromFile() {
        String[] temp = importScanner.nextLine().split("\\$");
        String balanceStr = temp[1];
        return getDoubleFromString(balanceStr);
    }

    private double getDoubleFromString(String priceStr) {
        double price;
        if (priceStr.contains(",")) {
            price = Double.parseDouble(priceStr.replace(",", "."));
        } else {
            price = Double.parseDouble(priceStr);
        }
        return price;
    }

    private Scanner createImportScanner() {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            printer.println(Message.FILE_NOT_FOUND);
        }
        return null;
    }
}
