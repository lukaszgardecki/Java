package com.example.strategy;

public class CheckoutPage {

    public void payForItems(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}
