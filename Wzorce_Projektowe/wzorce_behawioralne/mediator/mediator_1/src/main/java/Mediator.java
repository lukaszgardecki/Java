public class Mediator {
    private final Customer customer;
    private final ECommerceSite site;
    private final Driver driver;

    public Mediator() {
        customer = new Customer("123 Sunny Street");
        site = new ECommerceSite();
        driver = new Driver();
    }

    public void buy(String item, int quantity) {
        if (site.checkInStock(item, quantity)) {
            site.sell(item, quantity);
            driver.deliver(item, quantity, customer);
        }
    }
}
