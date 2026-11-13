package wzorce.behawioralne.polecenie.Zadanie2;

/**
 * Odbiorca (Receiver)
 */
public class Kuchnia {
    public void przygotuj(String danie) {
        System.out.println("Przygotowano: " + danie);
    }

    public void anuluj(String danie) {
        System.out.println("Anulowano: " + danie);
    }

    public void zrealizuj(String danie) {
        System.out.println("Zrealizowano: " + danie);
    }
}
