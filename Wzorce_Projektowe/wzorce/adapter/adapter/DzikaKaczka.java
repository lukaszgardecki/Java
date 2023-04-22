package wzorce.adapter.adapter;

public class DzikaKaczka implements Kaczka{

    @Override
    public void kwacz() {
        System.out.println("Kwa! Kwa!");
    }

    @Override
    public void lataj() {
        System.out.println("O rany! Latam!");
    }
}
