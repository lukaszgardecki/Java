package com.example.zaawansowanesynchronizatory.cyclicbarrier;

import java.util.Random;

/**
 * Tworzony jest obiekt typu Aukcja; następnie tworzone są obiekty typu Uczestnik,
 * aby wziąć udział w aukcji, po czym aukcja się rozpoczyna.
 */
public class AuctionDemo {
    public static void main(String[] args) {
        int numberParticipant = 5;
        Auction auction = new Auction(numberParticipant);
        int startPrice = 50;

        System.out.println("Start price : " + startPrice);

        for (int num = 0; num < numberParticipant; num++) {
            int cash = 100 + new Random().nextInt(50);
            Participant participant = new Participant(num, startPrice, cash, auction);
            auction.add(participant);
            participant.start();
        }
    }
}

