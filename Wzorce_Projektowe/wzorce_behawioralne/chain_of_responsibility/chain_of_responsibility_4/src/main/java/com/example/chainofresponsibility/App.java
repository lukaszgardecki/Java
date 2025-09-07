package com.example.chainofresponsibility;

public class App {

    public static void main(String[] args) {
        var request = new WithdrawalRequest(20, WithdrawalRequest.Currency.EUR);
        var atm = buildChain();
        atm.dispense(request);
    }

    public static ATM buildChain() {
        return new EuroATM(new UsDollarATM(null));
    }
}
