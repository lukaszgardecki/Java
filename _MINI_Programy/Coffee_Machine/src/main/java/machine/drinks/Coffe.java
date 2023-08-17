package machine.drinks;

public abstract class Coffe {
    protected String name;
    protected int amountOfWater;
    protected int amountOfMilk;
    protected int amountOfBeans;
    protected int price;


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
