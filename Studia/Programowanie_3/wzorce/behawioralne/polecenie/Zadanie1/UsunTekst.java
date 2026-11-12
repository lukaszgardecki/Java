package wzorce.behawioralne.polecenie.Zadanie1;

public class UsunTekst implements Polecenie {
    private Dokument dokument;
    private int ileZankow;
    private String usunietyTekst = "";

    UsunTekst(Dokument dokument, int ileZnakow) {
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
