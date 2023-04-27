package wzorce.proxy.ćwiczenie;

public class OsobaKomponentImpl implements OsobaKomponent{
    private String nazwa;
    private String płeć;
    private String zainteresowania;
    private int ranking;
    private int rankingLiczba = 0;

    @Override
    public String pobierzImię() {
        return nazwa;
    }

    @Override
    public String pobierzPłeć() {
        return płeć;
    }

    @Override
    public String pobierzZainteresowania() {
        return zainteresowania;
    }

    @Override
    public int pobierzRankingUrody() {
        if (rankingLiczba == 0) return 0;
        return (ranking / rankingLiczba);
    }

    @Override
    public void ustawImię(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void ustawPłeć(String płeć) {
        this.płeć = płeć;
    }

    @Override
    public void ustawZainteresowania(String zainteresowania) {
        this.zainteresowania = zainteresowania;
    }

    @Override
    public void ustawRankingUrody(int ranking) {
        this.ranking += ranking;
        rankingLiczba++;
    }
}
