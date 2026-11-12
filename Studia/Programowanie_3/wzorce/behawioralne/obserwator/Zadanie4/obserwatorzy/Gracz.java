package wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy;

public class Gracz implements Obserwator {
    @Override
    public void reagujNaZdarzenie(String zdarzenie) {
        System.out.println("Gracz reaguje na: " + zdarzenie);
    }
}
