package wzorce.behawioralne.polecenie.Zadanie1.polecenia;

import wzorce.behawioralne.polecenie.Zadanie1.Dokument;

public class UsunTekst implements Polecenie {
    private Dokument dokument;
    private int ileZankow;
    private String usunietyTekst = "";

    public UsunTekst(Dokument dokument, int ileZnakow) {
        this.dokument = dokument;
        this.ileZankow = ileZnakow;
    }

    @Override
    public void wykonaj() {
        usunietyTekst = dokument.usun(ileZankow);
    }

    @Override
    public void cofnij() {
        dokument.dodaj(usunietyTekst);
    }
}
