package wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy;

public class SystemAlarmowy implements Obserwator {
    @Override
    public void aktualizujKurs(float kurs) {
        if (kurs > 5.0f) {
            System.out.println("ALERT: kurs przekroczył 5.0!");
        }
    }
}
