package com.example.strategy;

public interface PaymentMethod {
    PaymentMethod byCard = () -> System.out.println("Payment made with card");
    PaymentMethod byBankTransfer = () -> System.out.println("Payment made by bank transfer");

    void pay();
}
