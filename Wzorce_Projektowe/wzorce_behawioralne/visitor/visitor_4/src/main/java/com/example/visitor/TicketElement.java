package com.example.visitor;

public interface TicketElement {

    int getPrice();

    void accept(Visitor visitor);
}
