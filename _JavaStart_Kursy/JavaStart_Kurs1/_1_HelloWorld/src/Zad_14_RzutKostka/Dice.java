package Zad_14_RzutKostka;

import java.util.Random;

public class Dice {
    Random random = new Random();
    int result;

    public Dice() {
        result = random.nextInt(6) + 1;
    }

    public Dice(int result) {
        this.result = result;
    }

    void roll() {
        result = random.nextInt(6) + 1;
    }

    void showResult() {
        System.out.println("Liczba oczek na kostce: " + result);
    }

}
