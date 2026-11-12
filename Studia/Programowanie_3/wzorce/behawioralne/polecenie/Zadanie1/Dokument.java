package wzorce.behawioralne.polecenie.Zadanie1;

class Dokument {
    private StringBuilder tekst = new StringBuilder();
    private String styl = "normalny";

    void dodaj(String t) {
        tekst.append(t);
    }

    String usun(int ile) {
        int start = Math.max(0, tekst.length() - ile);
        String usuniety = tekst.substring(start);
        tekst.delete(start, tekst.length());
        return usuniety;
    }

    void zmienStyl(String nowyStyl) {
        styl = nowyStyl;
    }

    void pokaz() {
        System.out.println("Styl: " + styl);
        System.out.println("Treść: " + tekst.toString());
    }

    public String getStyl() {
        return styl;
    }
}
