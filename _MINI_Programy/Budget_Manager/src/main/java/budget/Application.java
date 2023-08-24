package budget;

public class Application {
    public static final String TARGET_FILE_PATH = "src/main/resources/purchases.txt";
    public static void main(String[] args) {
        Budget budget = new Budget();
        BudgetController budgetApp = new BudgetController(budget);
        budgetApp.mainLoop();
    }
}
