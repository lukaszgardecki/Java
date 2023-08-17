package wzorce.proxy;

class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw();
        String accountNumber = atm.getAccountNumber();
        System.out.println(accountNumber);
    }
}
