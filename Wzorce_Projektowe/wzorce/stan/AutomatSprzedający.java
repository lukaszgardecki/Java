package wzorce.stan;

public class AutomatSprzedający {
    private Stan stanBrakGum;
    private Stan stanNieMaMonety;
    private Stan stanJestMoneta;
    private Stan stanGumaSprzedana;
    private Stan stanWygrana;

    private Stan stan = stanBrakGum;
    private int liczba = 0;

    public AutomatSprzedający(int liczbaGum) {
        stanBrakGum = new StanBrakGum(this);
        stanNieMaMonety = new StanNieMaMonety(this);
        stanJestMoneta = new StanJestMoneta(this);
        stanGumaSprzedana = new StanGumaSprzedana(this);
        stanWygrana = new StanWygrana(this);

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
