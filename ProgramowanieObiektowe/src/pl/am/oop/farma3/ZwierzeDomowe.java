package pl.am.oop.farma3;

public abstract class ZwierzeDomowe extends Zwierze {
    protected String nazwa;

    public ZwierzeDomowe(String nazwa, double masa) {
        super(masa);
        this.nazwa = nazwa;
    }
}
