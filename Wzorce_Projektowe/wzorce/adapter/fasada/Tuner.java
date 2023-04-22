package wzorce.adapter.fasada;

public class Tuner {
    private Wzmacniacz wzmacniacz;

    void włącz() {
        System.out.println("Tuner: włączony");
    }

    void wyłącz() {
        System.out.println("Tuner: wyłączony");
    }

    void ustawZakresAM() {
        System.out.println("Tuner: ustawiono zakres AM");
    }

    void ustawZakresFM() {
        System.out.println("Tuner: ustawiono zakres FM");
    }

    void ustawCzęstotliwość(String częstotliwość) {
        System.out.println("Tuner: ustawiono częstotliwość na " + częstotliwość);
    }
}

