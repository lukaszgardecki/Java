package wzorce.stan;

import java.util.Random;

public class StanJestMoneta implements Stan{
    private Random losowaWygrana = new Random(System.currentTimeMillis());
    private final AutomatSprzedający automatSprzedający;

    public StanJestMoneta(AutomatSprzedający automatSprzedający) {
        this.automatSprzedający = automatSprzedający;
    }

    @Override
    public void włóżMonetę() {
        System.out.println("Nie możesz włożyć więcej niż jednej monety");
    }

    @Override
    public void zwróćMonetę() {
        System.out.println("Moneta zwrócona");
        automatSprzedający.ustawStan(automatSprzedający.pobierzStanNieMaMonety());
    }

    @Override
    public void przekręćGałkę() {
        System.out.println("Obróciłeś gałkę...");
        int wygrana = losowaWygrana.nextInt(10);
        if (wygrana == 0) {
            automatSprzedający.ustawStan(automatSprzedający.pobierzStanWygrana());
        } else {
            automatSprzedający.ustawStan(automatSprzedający.pobierzStanGumaSprzedana());
        }
    }

    @Override
    public void wydaj() {
        System.out.println("Nie wydano gumy");
    }
}
