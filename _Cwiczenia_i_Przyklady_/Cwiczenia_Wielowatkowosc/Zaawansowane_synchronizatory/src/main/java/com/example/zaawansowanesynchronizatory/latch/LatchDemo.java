package com.example.zaawansowanesynchronizatory.latch;

import java.util.Random;

/**
 * W tym przykładzie nie wszystkie warunki są w pełni spełnione,
 * aby zapewnić prawidłowe działanie aplikacji we wszystkich możliwych sytuacjach wynikających
 * z logiki biznesowej i wielowątkowości aplikacji. Na przykład, ta aplikacja zgłosi wyjątek,
 * jeśli wszyscy oferenci wycofają się z aukcji, dlatego należy dodać odpowiednie sprawdzenie.
 * Można traktować ten przykład jako framework do zbudowania działającej aplikacji,
 * gdy istnieje kilka sesji sprzedaży partii na aukcji.
 */
public class LatchDemo {
    public static void main(String[] args) {
        int numbersParticipant = 5;
        AuctionLatch auction = new AuctionLatch(numbersParticipant);
        int startPrice = 110;
        auction.start();
        for (int num = 0; num < numbersParticipant; num++) {
            int cash = 100 + new Random().nextInt(20);
            ParticipantLatch participant = new ParticipantLatch(num, startPrice, cash, auction);
            auction.add(participant);
            participant.start();
        }
    }
}

