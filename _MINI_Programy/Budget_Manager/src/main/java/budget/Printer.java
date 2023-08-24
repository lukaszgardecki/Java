package budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Printer {


    public void println() {
        System.out.println();
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void printf(String format, Object... args) {
        System.out.format(format, args);
    }

    public void displayMenu() {
        String firstLine = "Choose your action:\n";
        String content = Arrays.stream(Option.values())
                .map(Option::toString)
                .collect(Collectors.joining("\n"));
        println(firstLine + content);
    }


    public void showSortTypes() {
        String text = """
                How do you want to sort?
                1) Sort all purchases
                2) Sort by type
                3) Sort certain type
                4) Back
                """;
        println(text);
    }

    public void printAllBoughtProductsFrom(Budget budget) {
        ArrayList<Product> allProductsInBudget =
                budget.getProductType(ProductType.ALL).getBoughtProducts();

        if (allProductsInBudget.size() == 0) {
            println("\nThe purchase list is empty!");
            return;
        }

        for (ProductType type : budget.getTypeList()) {
            ArrayList<Product> products = type.getBoughtProducts();

            if (products.size() != 0) {
                String template = String.format("""
                        %s:
                        %s
                        Total sum: $%.2f
                        """,
                        type.getName(),
                        products.stream().map(Product::toString).collect(Collectors.joining("\n")),
                        type.getTotalSum()
                );
                println(template);
            }
        }
    }

    public void printProductTypes() {
        println("Choose a purchase type:");
        Arrays.stream(ProductType.values())
                .filter(type -> type != ProductType.ALL)
                .forEach(this::println);
    }
}
