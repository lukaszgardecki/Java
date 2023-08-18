package machine;

import machine.components.*;
import machine.drinks.Coffe;
import machine.exception.ComponentNotFoundException;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoffeeMachine {
    private final Set<Component> componentList = new LinkedHashSet<>();
    private final Component money;

    public CoffeeMachine() {
        componentList.add(new Water(400));
        componentList.add(new Milk(540));
        componentList.add(new Beans(120));
        componentList.add(new Cups(9));
        money = new Money(550);
    }

    public Set<Component> getComponentList() {
        return componentList;
    }

    public void addWater(int extraWater) {
        getComponent(Water.class).add(extraWater);
    }

    public void addMilk(int extraMilk) {
        getComponent(Milk.class).add(extraMilk);
    }

    public void addBeans(int extraBeans) {
        getComponent(Beans.class).add(extraBeans);
    }

    public void addCups(int extraCups) {
        getComponent(Cups.class).add(extraCups);
    }

    public void addMoney(int extraCash) {
        money.add(extraCash);
    }

    public void subtractWater(int water) {
        getComponent(Water.class).subtract(water);
    }

    public void subtractMilk(int milk) {
        getComponent(Milk.class).subtract(milk);
    }

    public void subtractBeans(int beans) {
        getComponent(Beans.class).subtract(beans);
    }

    public void subtractCups(int cups) {
        getComponent(Cups.class).subtract(cups);
    }

    public void subtractMoney(int cash) {
        money.subtract(cash);
    }

    public int getWater() {
        return getComponent(Water.class).getValue();
    }

    public int getMilk() {
        return getComponent(Milk.class).getValue();
    }

    public int getBeans() {
        return getComponent(Beans.class).getValue();
    }

    public int getCups() {
        return getComponent(Cups.class).getValue();
    }

    public int getMoney() {
        return money.getValue();
    }

    public void takeMoney() {
        money.setValue(0);
    }

    public void prepareDrink(Coffe coffee) {
        coffee.getIngredients()
              .forEach(com -> getComponent(com.getClass())
                      .subtract(com.getValue()
                      )
        );
        addMoney(coffee.getPrice());
    }

    @Override
    public String toString() {
        String firstLine = "The coffee machine has:\n";
        String componentsStr = componentList.stream()
                .map(Component::toString)
                .collect(Collectors.joining("\n"));
        return firstLine + componentsStr + "\n" + money;
    }

    public List<Component> getMissingSupplies(Coffe coffee) {
        return coffee.getIngredients().stream()
                .filter(com -> getComponent(com.getClass()).getValue() < com.getValue())
                .toList();
    }

    private Component getComponent(Class<?> clazzz) {
        return componentList.stream()
                .filter(el -> el.getClass().equals(clazzz))
                .findFirst()
                .orElseThrow(ComponentNotFoundException::new);
    }
}
