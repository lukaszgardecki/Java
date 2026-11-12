package wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy;

public class WyswietlanieNaKonsoli implements Obserwator {
    @Override
    public void przetworzLog(String wiadomosc) {
        System.out.println("[Konsola] " + wiadomosc);
    }
}
