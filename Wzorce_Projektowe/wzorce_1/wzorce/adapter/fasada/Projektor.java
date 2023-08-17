package wzorce.adapter.fasada;

public class Projektor {
    private OdtwarzaczDVD dvd;

    void włącz() {
        System.out.println("Projektor: włączony");
    }

    void wyłącz() {
        System.out.println("Projektor: wyłączony");
    }

    void trybTV() {
        System.out.println("Projektor: tryb TV");
    }

    void trybSzerokoekranowy() {
        System.out.println("Projektor: włączonoy tryb szerokoekranowy (16:9)");
    }
}
