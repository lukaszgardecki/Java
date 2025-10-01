package com.example.zaawansowanesynchronizatory.exchanger;

import java.util.concurrent.TimeUnit;

/**
 * Klasa ExchangeDemo tworzy dwa obiekty typu Item oraz obiekt typu ItemAction w celu ich przetworzenia.
 * Następnie uruchamiane są dwa wątki – jeden, aby zmienić cenę pierwszego obiektu,
 * a drugi, aby zmienić opis drugiego obiektu. W rezultacie cena i opis obu obiektów ulegają zmianie.
 */
public class ExchangeDemo {
    public static void main(String[] args) {
        ItemAction action = new ItemAction();
        Item o1 = new Item(101, 5.0, "Tie");
        Item o2 = new Item(171, 7.0, "Gloves");

        System.out.println(o1 + "\n" + o2);

        new Thread(() -> action.doActionPrice(o1, 0.9f)).start();
        new Thread(() -> action.doActionDescription(o2, " with discount")).start();

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        System.out.println(o1 + "\n" + o2);
    }
}
