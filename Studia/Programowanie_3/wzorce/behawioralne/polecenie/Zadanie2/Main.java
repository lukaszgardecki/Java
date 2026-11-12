package wzorce.behawioralne.polecenie.Zadanie2;

/**
 * Zadanie 1: System zamówień w restauracji
 *
 *  - utwórz polecenia: DodajDoZamowienia, UsunZamowienie, ZrealizujZamowienie
 *  - obiekt Kelner pełni rolę wywołującego (Invoker)
 *  - Obiekt Kuchnia jest odbiorcą (Receiver)
 *  - dodaj możliwość kolejkowania zamówień i ich realizacji w odpowiedniej kolejności
 */
public class Main {
    public static void main(String[] args) {
        Kuchnia kuchnia = new  Kuchnia();
        Kelner kelner = new  Kelner();

        kelner.przyjmijPolecenie(new DodajDoZamowienia(kuchnia, "Pizza Margerita"));
        kelner.przyjmijPolecenie(new DodajDoZamowienia(kuchnia, "Spaghetti Carbonara"));
        kelner.przyjmijPolecenie(new UsunZamowienie(kuchnia, "Pizza Margherita"));
        kelner.przyjmijPolecenie(new ZrealizujZamowienie(kuchnia, "Spaghetti Carbonara"));

        kelner.wykonajZamowienia();
    }
}
