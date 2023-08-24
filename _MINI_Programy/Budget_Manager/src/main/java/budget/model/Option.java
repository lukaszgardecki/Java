package budget.model;

public enum Option {
    ADD_INCOME(1, "Add income"),
    ADD_PURCHASE(2, "Add purchase"),
    SHOW_PURCHASES(3, "Show list of purchases"),
    BALANCE(4, "Balance"),
    SAVE(5, "Save"),
    LOAD(6, "Load"),
    ANALYZE(7, "Analyze (sort)"),
    EXIT(0, "Exit");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + ") " + description;
    }
}
