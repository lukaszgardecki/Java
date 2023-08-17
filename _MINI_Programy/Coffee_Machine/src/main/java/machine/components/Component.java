package machine.components;

public abstract class Component {
    protected String name;
    private int value;
    protected String unit;

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

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s %s of %s", value, unit, name);
    }
}
