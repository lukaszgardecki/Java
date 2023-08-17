package wzorce.proxy;

public class BankAccount implements Account{
    @Override
    public void withdraw() {
        System.out.println("Wypłacam śrdoki");
    }

    @Override
    public String getAccountNumber() {
        return "123345";
    }
}
