package com.example.visitor;

public class DiscountVisitor implements Visitor {

    @Override
    public void visit(AdultTicket adultTicket) {
        adultTicket.setPrice(5);
    }

    @Override
    public void visit(GroupTicket groupTicket) {
        groupTicket.getElements().forEach(e -> e.accept(this));
    }
}
