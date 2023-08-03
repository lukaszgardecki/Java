package pl.am.oop.equals;

public class PorownanieStringow {
    public static void main(String[] args) {
        String nazwa1 = "testowy string";
        String nazwa2 = "testowy string";

        System.out.println(nazwa1 == nazwa2); // znak == porównuje czy obiekty wskazuj¹ to samo miejsce w pamiêci
        System.out.println(nazwa1.equals(nazwa2)); // <--equals sprawdza czy dany ci¹g znaków jest taki sam jak ten drugi
    }
}
