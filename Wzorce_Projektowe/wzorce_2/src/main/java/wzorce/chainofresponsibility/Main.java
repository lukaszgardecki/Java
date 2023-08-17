package wzorce.chainofresponsibility;

class Main {
    public static void main(String[] args) {
        BankPaymentHandler bank = new BankPaymentHandler();
        CreditCardPaymentHandler creditCard = new CreditCardPaymentHandler();
        PayPalPaymentHandler paypal = new PayPalPaymentHandler();
        bank.setNext(creditCard);
        creditCard.setNext(paypal);

        bank.handlePayment(600);
        bank.handlePayment(200);
        bank.handlePayment(1200);
        bank.handlePayment(600);
    }
}
