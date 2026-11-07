package wzorce.polecenie.Zadanie1;

public class DodajTekst implements Polecenie {
    private Dokument dokument;
    private String tekst;

    DodajTekst(Dokument dokument, String tekst) {
        this.dokument = dokument;
        this.tekst = tekst;
    }

    @Override
    public void wykonaj() {
        dokument.dodaj(tekst);
    }

    @Override
    public void cofnij() {
        dokument.usun(tekst.length());
    }
}
