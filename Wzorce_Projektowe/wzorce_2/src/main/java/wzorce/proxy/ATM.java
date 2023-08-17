package wzorce.proxy;

public class ATM implements Account {
    @Override
    public void withdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw();
    }

    @Override
    public String getAccountNumber() {
        BankAccount bankAccount = new BankAccount();
        return bankAccount.getAccountNumber();
    }
}
