package wzorce.adapter.fasada;

public class FasadaKinaDomowegoTest {
    public static void main(String[] args) {
        Wzmacniacz wzmacniacz = new Wzmacniacz();
        Tuner tuner = new Tuner();
        OdtwarzaczDVD dvd = new OdtwarzaczDVD();
        OdtwarzaczCD cd = new OdtwarzaczCD();
        Projektor projektor = new Projektor();
        Ekran ekran = new Ekran();
        OświetlenieKinowe oświetlenie = new OświetlenieKinowe();
        MaszynkaPopcorn popcorn = new MaszynkaPopcorn();

        FasadaKinaDomowego kinoDomowe = new FasadaKinaDomowego(wzmacniacz, tuner, dvd, cd, projektor, oświetlenie, ekran, popcorn);
        kinoDomowe.odtwarzanieFilmu("Poszukiwacze zaginiowej arki");
        kinoDomowe.koniecFilmu();
    }
}
