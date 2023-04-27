package wzorce.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AutomatSprzedający extends UnicastRemoteObject implements AutomatSprzedającyZdalny {
    private Stan stanBrakGum;
    private Stan stanNieMaMonety;
    private Stan stanJestMoneta;
    private Stan stanGumaSprzedana;
    private Stan stanWygrana;

    private Stan stan = stanBrakGum;
    private int liczba = 0;

    String lokalizacja;

    public AutomatSprzedający(String lokalizacja, int liczbaGum) throws RemoteException {
        stanBrakGum = new StanBrakGum(this);
        stanNieMaMonety = new StanNieMaMonety(this);
        stanJestMoneta = new StanJestMoneta(this);
        stanGumaSprzedana = new StanGumaSprzedana(this);
        stanWygrana = new StanWygrana(this);
        this.lokalizacja = lokalizacja;

        this.liczba = liczbaGum;
        if (liczbaGum > 0) stan = stanNieMaMonety;
    }

    public void włóżMonetę() {
        stan.włóżMonetę();
    }

    public void zwróćMonetę() {
        stan.zwróćMonetę();
    }

    public void przekręćGałkę() {
        stan.przekręćGałkę();
        stan.wydaj();
    }

    public void ustawStan(Stan stan) {
        this.stan = stan;
    }

    public void zwolnijGumę() {
        System.out.println("Wypada guma...");
        if (liczba != 0) liczba--;
    }

    public Stan pobierzStan() {
        return stan;
    }

    public Stan pobierzStanJestMoneta() {
        return stanJestMoneta;
    }

    public Stan pobierzStanNieMaMonety() {
        return stanNieMaMonety;
    }

    public Stan pobierzStanGumaSprzedana() {
        return stanGumaSprzedana;
    }

    public Stan pobierzStanBrakGum() {
        return stanBrakGum;
    }

    public Stan pobierzStanWygrana() {
        return stanWygrana;
    }

    public int pobierzLiczbęGum() {
        return liczba;
    }

    public String pobierzLokalizacja() {
        return lokalizacja;
    }

    public void napełnij(int liczba) {
        this.liczba += liczba;
        stan = stanNieMaMonety;
    }

    @Override
    public String toString() {
        return String.format("""
                Automaty Sprzedające SA
                Wolnostojący automat sprzedający Gumball Model #2004 Java
                Zapas: %s
                Automat oczekuje na monetę
                """, liczba);
    }
}
