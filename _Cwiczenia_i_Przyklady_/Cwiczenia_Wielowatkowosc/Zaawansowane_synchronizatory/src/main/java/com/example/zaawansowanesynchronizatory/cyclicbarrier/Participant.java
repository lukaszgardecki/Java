package com.example.zaawansowanesynchronizatory.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Klasa Participant to wątek definiujący klienta i jego ofertę na aukcję.
 * Klient składa ofertę i podchodzi do bariery, czekając na innych uczestników.
 * Po otwarciu bariery uczestnik, który wygrał, płaci za aukcję; pozostali uczestnicy nie robią nic.
 */
public class Participant extends Thread {
    private Integer participantId;
    private int currentLotPrice;
    private int cash;
    private Auction auction;

    public Participant(int id, int currentLotPrice, int cash, Auction auction) {
        this.participantId = id;
        this.currentLotPrice = currentLotPrice;
        this.cash = cash;
        this.auction = auction;
    }

    public Integer getBidId() {
        return participantId;
    }

    public int getCurrentLotPrice() {
        return currentLotPrice;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        try {
            System.out.println("Participant #" + participantId + " specifies a price. (cash = " + cash + ")");
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2500));
            int delta = new Random().nextInt(20);
            currentLotPrice += delta;
            System.out.println("Auction Participant #" + participantId + ": " + currentLotPrice);
            auction.getBarrier().await();
            System.out.println("Participant #" + participantId + " continue to work... (cash = " + cash + ")");
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}