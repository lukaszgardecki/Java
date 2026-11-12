package wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy;

public class WyswietlaczTemperatury implements Obserwator {
    @Override
    public void aktualizuj(float temperatura) {
        System.out.println("Temperatura: " + temperatura + "°C");
    }
}
