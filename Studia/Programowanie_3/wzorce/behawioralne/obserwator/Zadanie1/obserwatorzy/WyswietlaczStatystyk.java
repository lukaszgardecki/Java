package wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy;

public class WyswietlaczStatystyk implements  Obserwator {
    private float tMin = Float.MAX_VALUE;
    private float tMax = -Float.MAX_VALUE;
    private float tSrednia;
    private float suma = 0;
    private int liczbaPomiarow = 0;

    @Override
    public void aktualizuj(float temperatura) {
        if (temperatura < tMin) tMin = temperatura;
        if (temperatura > tMax) tMax = temperatura;
        suma += temperatura;
        liczbaPomiarow++;

        tSrednia = suma / liczbaPomiarow;
        System.out.printf("Statystyki: %s, Min: %s, Max: %s\n", tSrednia, tMin, tMax);
    }
}
