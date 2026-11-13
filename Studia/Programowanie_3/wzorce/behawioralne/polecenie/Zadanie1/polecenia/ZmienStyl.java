package wzorce.behawioralne.polecenie.Zadanie1.polecenia;

import wzorce.behawioralne.polecenie.Zadanie1.Dokument;

public class ZmienStyl implements Polecenie {
    private Dokument dokument;
    private String poprzedniStyl;
    private String nowyStyl;

    public ZmienStyl(Dokument dokument, String nowyStyl) {
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
