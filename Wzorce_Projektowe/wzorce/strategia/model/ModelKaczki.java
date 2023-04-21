package wzorce.strategia.model;


import wzorce.strategia.interfejs.kwakanie.Kwacz;
import wzorce.strategia.interfejs.latanie.NieLatam;

public class ModelKaczki extends Kaczka{
    public ModelKaczki() {
        latanieInterfejs = new NieLatam();
        kwakanieInterfejs = new Kwacz();
    }

    @Override
    void wyświetl() {
        System.out.println("Jestem modelem kaczki!");
    }
}
