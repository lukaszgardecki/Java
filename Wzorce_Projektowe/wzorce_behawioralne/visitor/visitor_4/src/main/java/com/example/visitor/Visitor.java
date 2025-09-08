package com.example.visitor;

public interface Visitor {
    void visit(AdultTicket adultTicket);

    void visit(GroupTicket groupTicket);
}
