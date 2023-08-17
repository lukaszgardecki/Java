package wzorce.adapter.fasada;

public class FasadaKinaDomowego {
    private Wzmacniacz wzmacniacz;
    private Tuner tuner;
    private OdtwarzaczDVD dvd;
    private OdtwarzaczCD cd;
    private Projektor projektor;
    private OświetlenieKinowe oświetlenie;
    private Ekran ekran;
    private MaszynkaPopcorn popcorn;

    public FasadaKinaDomowego(Wzmacniacz wzmacniacz,
                              Tuner tuner,
                              OdtwarzaczDVD dvd,
                              OdtwarzaczCD cd,
                              Projektor projektor,
                              OświetlenieKinowe oświetlenie,
                              Ekran ekran,
                              MaszynkaPopcorn popcorn) {
        this.wzmacniacz = wzmacniacz;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projektor = projektor;
        this.oświetlenie = oświetlenie;
        this.ekran = ekran;
        this.popcorn = popcorn;
    }

    public void odtwarzanieFilmu(String film) {
        System.out.println("--- Przygotuj się na seans filmowy...");
        popcorn.włącz();
        popcorn.przygotujPopcorn();
        oświetlenie.ściemniaj(10);
        ekran.wDół();
        projektor.włącz();
        projektor.trybSzerokoekranowy();
        wzmacniacz.włącz();
        wzmacniacz.ustawDVD(dvd);
        wzmacniacz.ustawDźwiękPrzestrzenny();
        wzmacniacz.ustawGłośność(5);
        dvd.włącz();
        dvd.odtwarzaj(film);
    }

    public void koniecFilmu() {
        System.out.println("\n--- Koniec seansu, wyłączam kino domowe...");
        popcorn.wyłącz();
        oświetlenie.włącz();
        ekran.wGórę();
        projektor.wyłącz();
        wzmacniacz.wyłącz();
        dvd.zatrzymaj();
        dvd.wysuńDysk();
        dvd.wyłącz();
    }
}
