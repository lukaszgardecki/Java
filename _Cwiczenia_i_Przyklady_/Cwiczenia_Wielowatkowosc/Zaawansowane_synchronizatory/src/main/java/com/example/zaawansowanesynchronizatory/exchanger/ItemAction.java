package com.example.zaawansowanesynchronizatory.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Klasa ItemAction opisuje dwie metody obsługi obiektów Item.
 *
 * Metoda doActionPrice() umożliwia zmianę ceny produktu dla dwóch obiektów typu Item,
 * a metoda doActionDescription() umożliwia zmianę opisu dwóch produktów.
 *
 * Metody wykorzystują w tym celu obiekt klasy Exchanger.
 */
public class ItemAction {
    private Exchanger<Item> exchanger = new Exchanger<>();

    public void doActionPrice(Item item, float discount) {
        try {
            item.setPrice(item.getPrice() * discount);
            item = exchanger.exchange(item);
            item.setPrice(item.getPrice() * discount);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }

    public void doActionDescription(Item item, String addDescription) {
        try {
            item.setDescription(item.getDescription() + addDescription);
            item = exchanger.exchange(item);
            item.setDescription(item.getDescription() + addDescription);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}
