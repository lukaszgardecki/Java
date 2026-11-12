package wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy;

public class AplikacjaMobilna implements Obserwator {
    @Override
    public void aktualizujKurs(float kurs) {
        System.out.println("Aplikacja: kurs = " + kurs);
    }
}
