package pl.lukasz.BazaProba;

public class Ksiazka {
    private final String imieAutora;
    private final String nazwiskoAutora;
    private final String tytul;
    private final double cena;

    //konstruktor: w taki sposób będziemy 'budować' nasz nowy obiekt (książkę)
    public Ksiazka(String imieAutora, String nazwiskoAutora, String tytul, double cena) {
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
        this.tytul = tytul;
        this.cena = cena;
    }

    public String getImieAutora() {
        return imieAutora;
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora;
    }

    public String getTytul() {
        return tytul;
    }

    public double getCena() {
        return cena;
    }
}
