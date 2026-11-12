package wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy;

public class ZapisDoPliku implements Obserwator {
    @Override
    public void przetworzLog(String wiadomosc) {
        System.out.println("[Plik] Zapisano: " + wiadomosc);
    }
}
