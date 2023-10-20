package com.example.biblioteka.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendBookAvailableNotification() {
        System.out.println("Powiadomienie zostało wysłane");
    }

    public void sendReservationCreatedNotification() {
        System.out.println("Rezerwacja została utworzona");
    }

    public void sendReservationCancelledNotification() {
        System.out.println("Rezerwacja została anulowana");
    }

    public void sendBookIssuedNotification() {
        System.out.println("Książka została wypożyczona");
    }

    public void sendBookHasRenewedNotification() {
        System.out.println("Książka została prolongowana");
    }
}
