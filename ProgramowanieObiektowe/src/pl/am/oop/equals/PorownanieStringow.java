package pl.am.oop.equals;

public class PorownanieStringow {
    public static void main(String[] args) {
        String nazwa1 = "testowy string";
        String nazwa2 = "testowy string";

        System.out.println(nazwa1 == nazwa2); // znak == por�wnuje czy obiekty wskazuj� to samo miejsce w pami�ci
        System.out.println(nazwa1.equals(nazwa2)); // <--equals sprawdza czy dany ci�g znak�w jest taki sam jak ten drugi
    }
}
