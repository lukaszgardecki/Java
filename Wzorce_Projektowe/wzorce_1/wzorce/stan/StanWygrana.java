package wzorce.stan;

public class StanWygrana implements Stan{
    private final AutomatSprzedający automatSprzedający;

    public StanWygrana(AutomatSprzedający automatSprzedający) {
        this.automatSprzedający = automatSprzedający;
    }

    @Override
    public void włóżMonetę() {
        System.out.println("Proszę czekać na gumę");
    }

    @Override
    public void zwróćMonetę() {
        System.out.println("Niestety, nie można zwrócić monety po przekręceniu gałki");
    }

    @Override
    public void przekręćGałkę() {
        System.out.println("Nie dostaniesz gumy  tylko dlatego, że przekręciłeś drugi raz!");
    }

    @Override
    public void wydaj() {
        System.out.println("WYGRAŁEŚ! Dostajesz drugą gumę");
        automatSprzedający.zwolnijGumę();
        if (automatSprzedający.pobierzLiczbęGum() == 0) {
            automatSprzedający.ustawStan(automatSprzedający.pobierzStanBrakGum());
        } else {
            automatSprzedający.zwolnijGumę();
            if (automatSprzedający.pobierzLiczbęGum() > 0) {
                automatSprzedający.ustawStan(automatSprzedający.pobierzStanNieMaMonety());
            } else {
                System.out.println("Ups, koniec gum!");
                automatSprzedający.ustawStan(automatSprzedający.pobierzStanBrakGum());
            }
        }
    }
}
