package wzorce.stan;

public class StanBrakGum implements Stan{
    private final AutomatSprzedający automatSprzedający;

    public StanBrakGum(AutomatSprzedający automatSprzedający) {
        this.automatSprzedający = automatSprzedający;
    }

    @Override
    public void włóżMonetę() {
        System.out.println("Nie możesz włożyć monety, gdy automat jest pusty");
    }

    @Override
    public void zwróćMonetę() {
        System.out.println("Nie włożyłeś monety");
    }

    @Override
    public void przekręćGałkę() {
        System.out.println("Przekręciłeś gałkę, ale automat jest pusty");
    }

    @Override
    public void wydaj() {
        System.out.println("Nie wydano gumy");
    }
}
