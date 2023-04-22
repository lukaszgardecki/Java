package wzorce.adapter.fasada;

public class OdtwarzaczCD {
    private Wzmacniacz wzmacniacz;

    void włącz() {
        System.out.println("OdtwarzaczCD: włączony");
    }

    void wyłącz() {
        System.out.println("OdtwarzaczCD: wyłączony");
    }

    void wysuńDysk() {
        System.out.println("OdtwarzaczCD: wysuwanie dysku");
    }

    void pauza() {
        System.out.println("OdtwarzaczCD: pauza");
    }

    void odtwarzaj(String film) {
        System.out.println("OdtwarzaczCD: odtwarzanie filmu " + film);
    }

    void zatrzymaj() {
        System.out.println("OdtwarzaczCD: stop");
    }
}
