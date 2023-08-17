package machine;

import machine.drinks.Coffe;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public CoffeeMachine() {
    }

    public void addWater(int extraWater) {
        water = water + extraWater;
    }

    public void addMilk(int extraMilk) {
        milk = milk + extraMilk;
    }

    public void addBeans(int extraBeans) {
        beans = beans + extraBeans;
    }

    public void addCups(int extraCups) {
        cups = cups + extraCups;
    }

    public void addMoney(int extraCash) {
        money = money + extraCash;
    }

    public void subtractWater(int water) {
        this.water = this.water + water;
    }

    public void subtractMilk(int milk) {
        this.milk = this.milk + milk;
    }

    public void subtractBeans(int beans) {
        this.beans = this.beans + beans;
    }

    public void subtractCups(int cups) {
        this.cups = this.cups + cups;
    }

    public void subtractMoney(int cash) {
        money = money + cash;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }

    public void takeMoney() {
        money = 0;
    }

    public boolean hasNotEnoughWaterToPrepare(Coffe coffe) {
        return water < coffe.getAmountOfWater();
    }

    public boolean hasNotEnoughMilkToPrepare(Coffe coffe) {
        return water < coffe.getAmountOfMilk();
    }

    public boolean hasNotEnoughBeansToPrepare(Coffe coffe) {
        return water < coffe.getAmountOfBeans();
    }

    public boolean hasNoCups() {
        return cups == 0;
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
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """,
                water, milk, beans, cups, money
        );
    }
}
