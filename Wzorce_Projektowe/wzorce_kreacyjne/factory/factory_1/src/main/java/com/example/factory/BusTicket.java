package com.example.factory;

public class BusTicket implements Ticket {

    @Override
    public int getPrice() {
        return 3;
    }
}
