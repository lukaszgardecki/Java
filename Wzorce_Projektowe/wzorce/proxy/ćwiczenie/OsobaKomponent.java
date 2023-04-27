package wzorce.proxy.ćwiczenie;

public interface OsobaKomponent {
    String pobierzImię();
    String pobierzPłeć();
    String pobierzZainteresowania();
    int pobierzRankingUrody();

    void ustawImię(String nazwa);
    void ustawPłeć(String płeć);

    void ustawZainteresowania(String zainteresowania);

    void ustawRankingUrody(int ranking);
}
