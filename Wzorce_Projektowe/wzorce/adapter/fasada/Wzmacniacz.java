package wzorce.adapter.fasada;

public class Wzmacniacz {
    private Tuner tuner;
    private OdtwarzaczDVD dvd;
    private OdtwarzaczCD cd;

    void włącz() {
        System.out.println("Wzmacniacz: włączony");
    }

    void wyłącz() {
        System.out.println("Wzmacniacz: wyłączony");
    }

    void ustawDVD(OdtwarzaczDVD dvd) {
        this.dvd = dvd;
        System.out.println("Wzmacniacz: wejście ustawiono odtwarzacz DVD");
    }

    void ustawCD(OdtwarzaczCD cd) {
        this.cd = cd;
        System.out.println("Wzmacniacz: wejście ustawiono odtwarzacz CD");
    }

    void ustawDźwiękStereo() {
        System.out.println("Wzmacniacz: włączono dźwięk stereo");
    }

    void ustawDźwiękPrzestrzenny() {
        System.out.println("Wzmacniacz: włączono dźwięk przestrzenny (5 głośników, 1 subwoofer)");
    }

    void ustawTuner(Tuner tuner) {
        this.tuner = tuner;System.out.println("Wzmacniacz: ustawiono tuner");

    }

    void ustawGłośność(int natężenie) {
        System.out.println("Wzmacniacz: siła głosu ustawiono na wartość " + natężenie);
    }
}
