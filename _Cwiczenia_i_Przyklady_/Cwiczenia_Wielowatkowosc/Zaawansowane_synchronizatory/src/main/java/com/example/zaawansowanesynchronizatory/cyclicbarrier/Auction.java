package com.example.zaawansowanesynchronizatory.cyclicbarrier;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

/**
 * Aby aplikacja działała poprawnie, rozmiar listy uczestników musi odpowiadać liczbie wątków oczekiwanych na barierze.
 *
 * Podczas tworzenia bariery opisany jest wątek, który określa zwycięzcę licytacji — metoda defineWinner().
 * Wątek jest uruchamiany po zadeklarowaniu wszystkich ofert, tj. gdy wszyscy uczestnicy wywołują metodę wait() na barierze.
 *
 *      - Jeśli uruchomionych zostanie więcej wątków uczestników niż zdefiniowano w barierze, „dodatkowe” oferty
 *        mogą nie zostać uwzględnione w obliczeniach zwycięzcy.
 *
 *      - Jeśli uruchomionych wątków uczestników jest mniej niż zdefiniowano w barierze, aplikacja blokuje się.
 *
 * Aby zapobiec takim sytuacjom, należy użyć metody wait() z parametrami.
 */
public class Auction {
    private final List<Participant> participants = new ArrayList<>();
    private CyclicBarrier barrier;

    public Auction(int numberParticipant) {
        this.barrier = new CyclicBarrier(numberParticipant, Auction.this::defineWinner);
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public void add(Participant e) {
        participants.add(e);
    }

    public void defineWinner() {
        Participant winner = Collections.max(participants,
                Comparator.comparingInt(Participant::getCurrentLotPrice));
        System.out.println("Participant #" + winner.getBidId()
                + ", price: " + winner.getCurrentLotPrice() + " win!");
        winner.setCash(winner.getCash() - winner.getCurrentLotPrice());
    }
}
