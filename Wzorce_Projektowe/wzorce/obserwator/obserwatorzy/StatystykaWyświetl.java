package wzorce.obserwator.obserwatorzy;

import wzorce.obserwator.obiektObserwowany.Podmiot;

public class StatystykaWyświetl implements Obserwator, WyświetlElement {
    private float tempŚrednia = 0.0f;
    private float tempMinimalna = 200;
    private float tempMaksymalna = 0.0f;
    private int numReadings;
    private Podmiot danePogodowe;

    public StatystykaWyświetl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temperatura, float wilgotność, float ciśnienie) {
        tempŚrednia += temperatura;
        numReadings++;

        if (temperatura > tempMaksymalna) {
            tempMaksymalna = temperatura;
        }

        if (temperatura < tempMinimalna) {
            tempMinimalna = temperatura;
        }
        wyświetl();
    }

    @Override
    public void wyświetl() {
        System.out.printf("Temperatura średnia / Maksymalna / Minimalna = %s / %s / %s%n", (tempŚrednia/numReadings), tempMaksymalna, tempMinimalna);
    }
}
