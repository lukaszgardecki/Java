package wzorce.strukturalne.dekorator.wprowadzenie;

public class SmsDekorator extends BazowyDekoratorNotyfikatora {

    SmsDekorator(INotyfikator notyfikator) {
        super(notyfikator);
    }

    @Override
    public void wyslij(String wiadomosc) {
        wyslijSMS(wiadomosc);
    }

    private void wyslijSMS(String wiadomosc) {
        super.wyslij(wiadomosc);
    }
}
