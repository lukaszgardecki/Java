package wzorce.wzorceZłożone;

public class Kwakolog implements Obserwator {

    @Override
    public void aktualizuj(KwakObserwowany kaczka) {
        System.out.println("Kwakolog: " + kaczka.getClass().getSimpleName() + " kwaknęła.");
    }
}
