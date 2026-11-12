package wzorce.strukturalne.kompozyt.Zadanie3;

public class Dzielenie implements  Wyrazenie {
    private Wyrazenie lewe, prawe;

    public Dzielenie(Wyrazenie lewe, Wyrazenie prawe) {
        this.lewe = lewe;
        this.prawe = prawe;
        if (prawe.oblicz() == 0) throw new ArithmeticException("Dzielenie przez zero.");
    }

    @Override
    public int oblicz() {
        return lewe.oblicz() / prawe.oblicz();
    }
}
