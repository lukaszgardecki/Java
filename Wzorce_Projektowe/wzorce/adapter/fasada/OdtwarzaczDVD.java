package wzorce.adapter.fasada;

public class OdtwarzaczDVD {
    private Wzmacniacz wzmacniacz;

    void włącz() {
        System.out.println("OdtwarzaczDVD: włączony");
    }

    void wyłącz() {
        System.out.println("OdtwarzaczDVD: wyłączony");
    }

    void wysuńDysk() {
        System.out.println("OdtwarzaczDVD: wysuwanie dysku DVD");
    }

    void pauza() {
        System.out.println("OdtwarzaczDVD: pauza");
    }

    void odtwarzaj(String film) {
        System.out.println("OdtwarzaczDVD: odtwarzanie filmu " + film);
    }

    void ustawPrzestrzennyEfektAudio() {
        System.out.println("OdtwarzaczDVD: ustawianie przestrzennego efektu audio");
    }

    void ustawDwukanałoweAudio() {
        System.out.println("OdtwarzaczDVD: ustawianie dwukanałowego audio");
    }

    void zatrzymaj() {
        System.out.println("OdtwarzaczDVD: stop");
    }
}
