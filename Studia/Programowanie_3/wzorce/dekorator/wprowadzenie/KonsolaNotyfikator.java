package wzorce.dekorator.wprowadzenie;

public class KonsolaNotyfikator implements INotyfikator {

    @Override
    public void wyslij(String wiadomosc) {
        System.out.println("Wiadomość: " + wiadomosc);
    }
}
