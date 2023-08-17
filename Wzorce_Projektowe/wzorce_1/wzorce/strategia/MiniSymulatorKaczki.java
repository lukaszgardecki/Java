package wzorce.strategia;

import wzorce.strategia.interfejs.latanie.LotZNapędemRakietowym;
import wzorce.strategia.model.DzikaKaczka;
import wzorce.strategia.model.Kaczka;
import wzorce.strategia.model.ModelKaczki;

class MiniSymulatorKaczki {

    public static void main(String[] args) {
        Kaczka dzika = new DzikaKaczka();
        dzika.wykonajKwacz();
        dzika.wykonajLeć();

        Kaczka model = new ModelKaczki();
        model.wykonajLeć();
        model.ustawLatanieInterfejs(new LotZNapędemRakietowym());
        model.wykonajLeć();
    }
}
