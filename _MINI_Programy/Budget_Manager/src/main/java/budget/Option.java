package budget;

public enum Option {
    EXIT(0, "Exit"),
    ADD_INCOME(1, "Add income"),
    ADD_PURCHASE(2, "Add purchase"),
    SHOW_PURCHASES(3, "Show list of purchases"),
    BALANCE(4, "Balance"),
    SAVE(5, "Save"),
    LOAD(6, "Load"),
    ANALYZE(7, "Analyze (sort)");

    private final int value;
    private final String descrption;

    Option(int value, String descrption) {
        this.value = value;
        this.descrption = descrption;
    }

    public int getValue() {
        return value;
    }

    public String getDescrption() {
        return descrption;
    }
}
