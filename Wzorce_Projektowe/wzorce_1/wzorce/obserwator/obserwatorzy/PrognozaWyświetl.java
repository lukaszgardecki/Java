package wzorce.obserwator.obserwatorzy;

import wzorce.obserwator.obiektObserwowany.Podmiot;

public class PrognozaWyświetl implements Obserwator, WyświetlElement {
    private float bieżąceCiśnienie = 1010.1f;
    private float ostatnieCiśnienie;
    private Podmiot danePogodowe;

    public PrognozaWyświetl(Podmiot danePogodowe) {
        this.danePogodowe = danePogodowe;
        danePogodowe.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(float temperatura, float wilgotność, float ciśnienie) {
        this.ostatnieCiśnienie = bieżąceCiśnienie;
        bieżąceCiśnienie = ciśnienie;
        wyświetl();
    }

    @Override
    public void wyświetl() {
        System.out.print("Prognoza: ");
        if (bieżąceCiśnienie > ostatnieCiśnienie) {
            System.out.println("Niebawem znacząca poprawa pogody!");
        } else if (bieżąceCiśnienie == ostatnieCiśnienie) {
            System.out.println("Bieżąca pogoda się utrzyma");
        } else if (bieżąceCiśnienie < ostatnieCiśnienie) {
            System.out.println("Przygotuj się na nadejście zimnych, deszczowych dni");
        }
    }
}
