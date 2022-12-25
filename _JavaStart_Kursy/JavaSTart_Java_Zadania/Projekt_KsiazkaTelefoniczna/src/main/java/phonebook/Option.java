package phonebook;

import java.util.NoSuchElementException;

public enum Option {
    ADD(0, "Dodaj kontakt"),
    FIND_BY_NAME(1, "Szukaj po nazwie"),
    FIND_BY_TELEPHONE(2, "Szukaj po numerze telefonu"),
    DELETE(3, "Usuń"),
    EXIT(4, "Wyjście");

    private int num;
    private String name;

    Option(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    static Option convertToOption(int option) {
        if (option >= values().length || option < 0) {
            throw new NoSuchElementException();
        }
        return values()[option];
    }

    @Override
    public String toString() {
        return num + " - " + name;
    }
}
