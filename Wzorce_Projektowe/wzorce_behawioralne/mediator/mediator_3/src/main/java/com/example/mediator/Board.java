package com.example.mediator;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Ticket> inProgressTickets = new ArrayList<>();
    private final List<Ticket> doneTickets = new ArrayList<>();

    public List<Ticket> getDoneTickets() {
        return this.doneTickets;
    }

    public void addTicketToInProgressTickets(Ticket ticket) {
        inProgressTickets.add(ticket);
        System.out.println("Ticket added to inProgressTickets");
    }

    public void addTicketToDoneTickets(Ticket ticket) {
        doneTickets.add(ticket);
        System.out.println("Ticket added to doneTickets");
        inProgressTickets.remove(ticket);
        System.out.println("Ticket removed from inProgressTickets");
    }


}
