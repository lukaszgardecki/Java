package wzorce.adapter.fasada;

public class MaszynkaPopcorn {

    void włącz() {
        System.out.println("Maszynka do robienia popcoru: włączona");
    }

    void wyłącz() {
        System.out.println("Maszynka do robienia popcoru: wyłączona");
    }

    void przygotujPopcorn() {
        System.out.println("Maszynka do robienia popcoru: popcorn w drodze!");
    }
}
