public class PaymentService {
    public static final double HIGHER_NAP = 15;
    public static final double LOWER_NAP = 10;

    public double getNap(Order order) {
        double price = order.getPrice();
        if (price < 100) {
            return order.getPrice() * (HIGHER_NAP / 100);
        }
         return order.getPrice() * (LOWER_NAP / 100);
    }

    public double getDishesPrice(Order order) {
        return order.getPrice();
    }

    public double getFullPrice(Order order) {
        return getNap(order) + getDishesPrice(order);
    }
}
