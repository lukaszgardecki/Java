package com.example.strategy;

public class App {

    public static void main(String[] args) {
        var checkoutPage = new CheckoutPage();

        checkoutPage.payForItems(PaymentMethod.byCard);
        checkoutPage.payForItems(PaymentMethod.byBankTransfer);
    }
}
