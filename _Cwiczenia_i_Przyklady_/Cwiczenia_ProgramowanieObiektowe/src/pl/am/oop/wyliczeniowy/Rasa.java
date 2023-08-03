package pl.am.oop.wyliczeniowy;

public enum Rasa {
    OWCZAREK("Owczarek Niemiecki"),
    MOPS("MopsMopsik"),
    BULDOG("Buldog"),
    KUNDEL("Kundel bury");

    private String pelnaNazwa;

    Rasa(String pelnaNazwa) {
        this.pelnaNazwa = pelnaNazwa;
    }

    public String getPelnaNazwa() {
        return pelnaNazwa;
    }
}
