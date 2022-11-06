package Zad_4;

class Zad_4 {
    public static void main(String[] args) {
        double netPrice = 4.56;
        double tax = 0.23;
        double grossPrice = netPrice * (1.0 + tax);

        System.out.printf("Wino z pomarañczy: -cena netto: %.2fz³, -podatek: %.0f%%, -cena brutto: %.2fz³", netPrice, tax*100, grossPrice);
    }


}
