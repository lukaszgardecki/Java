package wzorce.strategia.model;


import wzorce.strategia.interfejs.kwakanie.KwakanieInterfejs;
import wzorce.strategia.interfejs.latanie.LatanieInterfejs;

public abstract class Kaczka {
    LatanieInterfejs latanieInterfejs;
    KwakanieInterfejs kwakanieInterfejs;

    Kaczka() {}

    abstract void wyświetl();

    public void wykonajLeć() {
        latanieInterfejs.leć();
    }

    public void wykonajKwacz() {
        kwakanieInterfejs.kwacz();
    }

    void pływaj() {
        System.out.println("Wszystkie kaczki pływają, nawet te sztuczne!");
    }

    public void ustawLatanieInterfejs(LatanieInterfejs li) {
        latanieInterfejs = li;
    }

    void ustawKwakanieInterfejs(KwakanieInterfejs ki) {
        kwakanieInterfejs = ki;
    }
}
