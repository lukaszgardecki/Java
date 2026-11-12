package wzorce.behawioralne.polecenie.Zadanie1;

public class ZmienStyl implements Polecenie {
    private Dokument dokument;
    private String poprzedniStyl;
    private String nowyStyl;

    ZmienStyl(Dokument dokument, String nowyStyl) {
        this.dokument = dokument;
        this.poprzedniStyl = dokument.getStyl();
        this.nowyStyl = nowyStyl;
    }

    @Override
    public void wykonaj() {
        dokument.zmienStyl(nowyStyl);
    }

    @Override
    public void cofnij() {
        dokument.zmienStyl(poprzedniStyl);
    }
}
