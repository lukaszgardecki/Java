package com.example.zaawansowanesynchronizatory.latch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * Klasa AuctionLatch to wątek definiujący sposób prowadzenia aukcji.
 * W klasie ustawione są dwa obiekty typu CountDownLatch: jeden do zliczania początku aukcji, a drugi do jej zakończenia.
 */
public class AuctionLatch extends Thread {
    private List<ParticipantLatch> participants = new ArrayList<>();
    private CountDownLatch latchEndAuction = new CountDownLatch(1); //zatrzask na jedno zliczenie, aby zakończyć aukcję
    private CountDownLatch latchAuctionBegin; //zatrzask do liczenia oferentów

    public AuctionLatch(int numbersParticipant) {
        latchAuctionBegin = new CountDownLatch(numbersParticipant);
    }

    public void add(ParticipantLatch e) {
        participants.add(e);
    }

    public CountDownLatch getLatchEndAuction() {
        return latchEndAuction;
    }

    public CountDownLatch getLatchAuctionBegin() {
        return latchAuctionBegin;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for participants to bet...");
            latchAuctionBegin.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        defineWinner();
        latchEndAuction.countDown();
    }

    private void defineWinner() {
        ParticipantLatch winner = Collections.max(participants
                .stream()
                .filter(o -> !o.isLost())
                .collect(Collectors.toList()), Comparator.comparingInt(ParticipantLatch::getCurrentLotPrice));
        System.out.println("Participant #" + winner.getParticipantId()
                + ", price: " + winner.getCurrentLotPrice() + " win!");
        winner.setCash(winner.getCash() - winner.getCurrentLotPrice());
    }
}