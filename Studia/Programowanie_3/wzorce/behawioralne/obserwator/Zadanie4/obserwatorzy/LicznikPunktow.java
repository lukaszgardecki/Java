package wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy;

public class LicznikPunktow implements Obserwator {
    private int licznik = 0;

    @Override
    public void reagujNaZdarzenie(String zdarzenie) {
        switch (zdarzenie) {
            case "pokonano bossa" -> licznik += 100;
            case "awans na poziom" -> licznik += 50;
        }
        System.out.println("Licznik punktów: " + licznik);
    }
}
