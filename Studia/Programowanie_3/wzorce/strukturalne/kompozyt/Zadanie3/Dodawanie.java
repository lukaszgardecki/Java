package wzorce.strukturalne.kompozyt.Zadanie3;

public class Dodawanie implements  Wyrazenie {
    private Wyrazenie lewe, prawe;

    public Dodawanie(Wyrazenie lewe, Wyrazenie prawe) {
        this.lewe = lewe;
        this.prawe = prawe;
    }

    @Override
    public int oblicz() {
        return lewe.oblicz() + prawe.oblicz();
    }
}
