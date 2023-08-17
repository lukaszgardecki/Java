package wzorce.builder;

import wzorce.builder.example1.Burger;
import wzorce.builder.example2.Meal;
import wzorce.builder.example2.MealDirector;
import wzorce.builder.example2.NonVegMealBuilder;

class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder()
                .extraCheese(true)
                .egg(true)
                .lettuce(true)
                .build();

        Meal meal = new MealDirector(new NonVegMealBuilder()).prepareMeal();
    }
}
