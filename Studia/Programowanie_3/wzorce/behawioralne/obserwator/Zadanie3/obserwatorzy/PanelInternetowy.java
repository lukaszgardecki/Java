package wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy;

public class PanelInternetowy implements Obserwator {
    @Override
    public void aktualizujKurs(float kurs) {
        System.out.println("Panel internetowy: kurs = " + kurs);
    }
}
