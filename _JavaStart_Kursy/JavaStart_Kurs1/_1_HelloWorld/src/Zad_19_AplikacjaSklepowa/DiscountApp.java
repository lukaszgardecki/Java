package Zad_19_AplikacjaSklepowa;

class DiscountApp {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        PrintService printService = new PrintService();

        Client client1 = new Client(null, "Kowalski", true);
        double price1 = 1560;
        double discountPrice1 = discountService.caculateDiscountPrice(client1, price1);
        printService.displayInfo(client1, price1, discountPrice1);

        Client client2 = new Client("Karol", "Nowak", false);
        double price2 = 900;
        double discountPrice2 = discountService.caculateDiscountPrice(client2, price2);
        printService.displayInfo(client2, price2, discountPrice2);





    }
}
