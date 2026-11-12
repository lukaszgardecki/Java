package wzorce.behawioralne.polecenie.Zadanie4;

public class KontoBankowe {
    private int saldo = 0;

    void wplata(int kwota) {
        saldo += kwota;
        System.out.println("Wpłata: " + kwota + ", saldo: " + saldo);
    }

    void wyplata(int kwota) {
        saldo -= kwota;
        System.out.println("Wypłata: " + kwota + ", saldo: " + saldo);
    }

    void przelew(int kwota, String odbiorca) {
        saldo -= kwota;
        System.out.println("Przelew: " + kwota + " do " + odbiorca + ", saldo: " + saldo);
    }
}
