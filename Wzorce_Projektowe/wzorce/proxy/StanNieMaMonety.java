package wzorce.proxy;

public class StanNieMaMonety implements Stan {
    transient private final AutomatSprzedający automatSprzedający;

    public StanNieMaMonety(AutomatSprzedający automatSprzedający) {
        this.automatSprzedający = automatSprzedający;
    }

    @Override
    public void włóżMonetę() {
        System.out.println("Moneta przyjęta");
        automatSprzedający.ustawStan(automatSprzedający.pobierzStanJestMoneta());
    }

    @Override
    public void zwróćMonetę() {
        System.out.println("Nie włożyłeś monety");
    }

    @Override
    public void przekręćGałkę() {
        System.out.println("Zanim przekręcisz gałkę, wrzuć monetę");
    }

    @Override
    public void wydaj() {
        System.out.println("Najpierw zapłać");
    }
}
