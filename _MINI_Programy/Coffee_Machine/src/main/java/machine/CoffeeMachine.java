package machine;

import machine.components.*;
import machine.drinks.Coffe;

public class CoffeeMachine {
    private final Component water;
    private final Component milk;
    private final Component beans;
    private final Component cups;
    private final Component money;

    public CoffeeMachine() {
        water = new Water(400);
        milk = new Milk(540);
        beans = new Beans(120);
        cups = new Cups(9);
        money = new Money(550);
    }

    public void addWater(int extraWater) {
        water.add(extraWater);
    }

    public void addMilk(int extraMilk) {
        milk.add(extraMilk);
    }

    public void addBeans(int extraBeans) {
        beans.add(extraBeans);
    }

    public void addCups(int extraCups) {
        cups.add(extraCups);
    }

    public void addMoney(int extraCash) {
        money.add(extraCash);
    }

    public void subtractWater(int water) {
        this.water.subtract(water);
    }

    public void subtractMilk(int milk) {
        this.milk.subtract(milk);
    }

    public void subtractBeans(int beans) {
        this.beans.subtract(beans);
    }

    public void subtractCups(int cups) {
        this.cups.subtract(cups);
    }

    public void subtractMoney(int cash) {
        money.subtract(cash);
    }

    public int getWater() {
        return water.getValue();
    }

    public int getMilk() {
        return milk.getValue();
    }

    public int getBeans() {
        return beans.getValue();
    }

    public int getCups() {
        return cups.getValue();
    }

    public int getMoney() {
        return money.getValue();
    }

    public void takeMoney() {
        money.setValue(0);
    }

    public boolean hasNotEnoughWaterToPrepare(Coffe coffe) {
        return water.getValue() < coffe.getAmountOfWater();
    }

    public boolean hasNotEnoughMilkToPrepare(Coffe coffe) {
        return water.getValue() < coffe.getAmountOfMilk();
    }

    public boolean hasNotEnoughBeansToPrepare(Coffe coffe) {
        return water.getValue() < coffe.getAmountOfBeans();
    }

    public boolean hasNoCups() {
        return cups.getValue() == 0;
    }

    public void prepareDrink(Coffe coffee) {
        subtractWater(coffee.getAmountOfWater());
        subtractMilk(coffee.getAmountOfMilk());
        subtractBeans(coffee.getAmountOfBeans());
        subtractCups(1);
        addMoney(coffee.getPrice());
    }

    @Override
    public String toString() {
        return String.format("""
                The coffee machine has:
                %s ml of water
                %s ml of milk
                %s g of coffee beans
                %s disposable cups
                $%s of money
                """,
                water, milk, beans, cups, money
        );
    }
}
