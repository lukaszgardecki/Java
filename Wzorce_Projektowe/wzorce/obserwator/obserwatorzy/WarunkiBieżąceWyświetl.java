package wzorce.obserwator.obserwatorzy;

import wzorce.obserwator.obiektObserwowany.Podmiot;

public class WarunkiBieżąceWyświetl implements Obserwator, WyświetlElement {
    private float temperatura;
    private float wilgotność;
    private Podmiot danePogodowe;

    public WarunkiBieżąceWyświetl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temperatura, float wilgotność, float ciśnienie) {
        this.temperatura = temperatura;
        this.wilgotność = wilgotność;
        wyświetl();
    }

    @Override
    public void wyświetl() {
        System.out.printf("Warunki bieżące %s stopni C oraz %s %% wilgotność%n", temperatura, wilgotność);
    }
}
