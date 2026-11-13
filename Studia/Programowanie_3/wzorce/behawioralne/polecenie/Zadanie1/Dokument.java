package wzorce.behawioralne.polecenie.Zadanie1;

/**
 * Odbiorca (Receiver)
 */
public class Dokument {
    private StringBuilder tekst = new StringBuilder();
    private String styl = "normalny";

    public void dodaj(String t) {
        tekst.append(t);
    }

    public String usun(int ile) {
        int start = Math.max(0, tekst.length() - ile);
        String usuniety = tekst.substring(start);
        tekst.delete(start, tekst.length());
        return usuniety;
    }

    public void zmienStyl(String nowyStyl) {
        styl = nowyStyl;
    }

    public void pokaz() {
        System.out.println("Styl: " + styl);
        System.out.println("Treść: " + tekst.toString());
    }

    public String getStyl() {
        return styl;
    }
}
