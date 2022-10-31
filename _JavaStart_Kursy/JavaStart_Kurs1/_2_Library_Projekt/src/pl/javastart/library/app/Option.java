package pl.javastart.library.app;

public enum Option {
    EXIT(0, "wyj�cie z programu"),
    ADD_BOOK(1, "dodanie nowej ksi��ki"),
    ADD_MAGAZINE(2, "dodanie nowego magazynu"),
    PRINT_BOOKS(3, "wy�wietl dost�pne ksi��ki"),
    PRINT_MAGAZINES(4, "wy�wietl dost�pne magazyny");

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
        return value + " - " + description;
    }

    static Option createFromInt(int option) {
        return Option.values()[option];
    }
}
