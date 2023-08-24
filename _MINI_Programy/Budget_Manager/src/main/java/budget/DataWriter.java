package budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataWriter {
    private final Printer printer;
    private final File file;

    public DataWriter(Printer printer) {
        this.printer = printer;
        this.file = new File(Application.TARGET_FILE_PATH);
    }


    public void save(Budget budget) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.format("Balance: $%.2f\n\n", budget.getBalance()));

            for(ProductType type : budget.getTypeList()) {
                String text = createStringTemplateToSave(type);
                writer.write(text);
            }
            printer.println("\n" + Message.PURCHASE_SAVED);
        } catch (IOException e) {
            printer.println(Message.FILE_NOT_FOUND);
        }
    }

    private String createStringTemplateToSave(ProductType productType) {
        ArrayList<Product> boughtProducts = productType.getBoughtProducts();
        String products = createBoughtProductsListStringToSave(boughtProducts);
        return String.format("""
                        %d %s:
                        %s
                        --------------------------------------------------------
                            %42s  $%.2f
                            
                        """,
                productType.getValue(),
                productType.getName(),
                products,"TOTAL:",
                productType.getTotalSum()
        );
    }
    private String createBoughtProductsListStringToSave(List<Product> boughtProducts) {
        String listOfPurchases;
        if (boughtProducts.size() == 0) {
            listOfPurchases = "\tThe purchase products is empty!\n";
        } else {
            listOfPurchases = boughtProducts.stream()
                    .map(p -> String.format("\t- %40s  $%-5s", p.getName(), String.format("%.2f", p.getPrice())))
                    .collect(Collectors.joining("\n"));
        }
        return listOfPurchases;
    }

}
