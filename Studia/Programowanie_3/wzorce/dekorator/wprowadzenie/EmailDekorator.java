package wzorce.dekorator.wprowadzenie;

public class EmailDekorator extends BazowyDekoratorNotyfikatora {

    EmailDekorator(INotyfikator notyfikator) {
        super(notyfikator);
    }

    @Override
    public void wyslij(String wiadomosc) {
        wyslijEmail(wiadomosc);
    }

    private void wyslijEmail(String wiadomosc) {
        super.wyslij(wiadomosc);
    }
}
