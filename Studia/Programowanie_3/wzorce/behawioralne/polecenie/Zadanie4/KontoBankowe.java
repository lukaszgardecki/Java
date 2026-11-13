package wzorce.behawioralne.polecenie.Zadanie4;

/**
 * Odbiorca (Receiver)
 */
public class KontoBankowe {
    private int saldo = 0;

    public void wplata(int kwota) {
        saldo += kwota;
        System.out.println("Wpłata: " + kwota + ", saldo: " + saldo);
    }

    public void wyplata(int kwota) {
        saldo -= kwota;
        System.out.println("Wypłata: " + kwota + ", saldo: " + saldo);
    }

    public void przelew(int kwota, String odbiorca) {
        saldo -= kwota;
        System.out.println("Przelew: " + kwota + " do " + odbiorca + ", saldo: " + saldo);
    }
}
