package Zad_35_OwoceWsklepie;

public class GroceryShop {
    public static void main(String[] args) {
        Apple apple = new Apple(220, "szampion");
        Fruit fruit = new Fruit(180, "pomarañczowate");
        
        System.out.println(apple.getInfo());
        System.out.println(fruit.getInfo());
    }
}
