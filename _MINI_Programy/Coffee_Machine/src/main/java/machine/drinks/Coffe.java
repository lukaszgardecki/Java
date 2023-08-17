package machine.drinks;

public abstract class Coffe {
    protected final String name;
    protected final int amountOfWater;
    protected final int amountOfMilk;
    protected final int amountOfBeans;
    protected final int price;

    public Coffe(String name, int amountOfWater, int amountOfMilk, int amountOfBeans, int price) {
        this.name = name;
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfBeans = amountOfBeans;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public int getAmountOfMilk() {
        return amountOfMilk;
    }

    public int getAmountOfBeans() {
        return amountOfBeans;
    }

    public int getPrice() {
        return price;
    }
}
