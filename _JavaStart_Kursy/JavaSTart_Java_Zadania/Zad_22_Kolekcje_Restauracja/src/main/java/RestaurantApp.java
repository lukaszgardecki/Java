import java.util.Scanner;

/**
 * Idąc do rejestracji często można się spotkać z problemem dawania napiwków.
 * Przy płaceniu zastanawiamy się, czy oraz ile napiwku powinniśmy zostawić.
 *
 * Zadaniem naszej aplikacji będzie symulowanie zamawiania dań w restauracji oraz rozwiąże
 * problem przydzielania napiwków. Aplikacja po uruchomieniu powinna wyświetlić dostępne w menu
 * pozycje wraz z cenami. Użytkownik wymienia następnie po przecinku numery pozycji z menu, które
 * chce zamówić a w wyniku powinien zobaczyć sumę do zapłaty z uwzględnieniem kosztów obsługi.
 *
 * Koszt obsługi wyliczamy według następującego algorytmu:
 *   - jeśli suma zamówienia jest mniejsza niż 100zł, to naliczamy koszt obsługi w wysokości 15% ceny,
 *   - jeśli suma zamówienia jest większa, bądź równa 100zł, to naliczany jest koszt obsługi w wysokości 10% ceny.
 */

public class RestaurantApp {
    private static PaymentService paymentService = new PaymentService();
    private static Menu menu = new Menu();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();
        Order order = createOrder();
        countAndPrintBill(order);
    }

    private static void printMenu() {
        System.out.println("Witamy w naszej restauracji!");
        System.out.println("Dzisiejsze Menu:");
        menu.getMenu().forEach(System.out::println);
    }

    private static void countAndPrintBill(Order order) {
        double fullPrice = paymentService.getFullPrice(order);
        double dishesPrice = paymentService.getDishesPrice(order);
        double servicePrice = paymentService.getNap(order);
        System.out.printf("""
                Do zapłaty: %.2f zł, w tym:
                Koszt dań: %.2f zł
                Koszt obsługi: %.2f zł
                """,
                fullPrice, dishesPrice, servicePrice);
    }

    private static Order createOrder() {
        System.out.println("Zamów wybrane potrawy, wymieniając ich numery po przecinku:");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        Order order = new Order();
        for (String id : split) {
            int intId = Integer.parseInt(id.trim());
            if (menu.isDishExists(intId)) {
                order.add(menu.getDish(intId));
            }
        }
        return order;
    }
}
