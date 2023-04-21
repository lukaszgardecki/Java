package wzorce.strategia.model;


import wzorce.strategia.interfejs.kwakanie.Kwacz;
import wzorce.strategia.interfejs.latanie.LatamBoMamSkrzydła;

public class DzikaKaczka extends Kaczka {
    public DzikaKaczka() {
        kwakanieInterfejs = new Kwacz();
        latanieInterfejs = new LatamBoMamSkrzydła();
    }

    @Override
    void wyświetl() {
        System.out.println("Jestem prawdziwą Dziką Kaczką");
    }
}
