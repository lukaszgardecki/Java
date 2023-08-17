package machine.components;

public abstract class Component {
    private int value;

    public Component(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.value = this.value + value;
    }

    public void subtract(int value) {
        this.value = this.value - value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
