package machine;

import machine.exception.NoSuchOptionException;

public enum Option {
    EXIT(0, "exit"),
    BUY(1, "buy"),
    FILL(2, "fill"),
    TAKE(3, "take"),
    REMAINING(4, "remaining");

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
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Brak opcji o id " + option);
        }
    }
}
