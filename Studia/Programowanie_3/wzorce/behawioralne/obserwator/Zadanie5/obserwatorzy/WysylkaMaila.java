package wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy;

public class WysylkaMaila implements Obserwator {
    @Override
    public void przetworzLog(String wiadomosc) {
        System.out.println("[E-mail] Wysłano wiadomość: " + wiadomosc);
    }
}
