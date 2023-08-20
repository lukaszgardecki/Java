package budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataReader {
    private final Scanner scanner;
    private final Printer printer;
    private final String filePath = "purchases.txt";

    public DataReader(Printer printer) {
        this.scanner = new Scanner(System.in);
        this.printer = printer;
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
                printer.println(Message.INCORRECT_INT);
            }
        } while (!intOK);
        return num;
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

    public void saveFile() {
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
}
