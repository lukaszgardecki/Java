package wzorce.adapter.fasada;

public class OświetlenieKinowe {

    void włącz() {
        System.out.println("Oświetlenie sufitowe kina: włączone");
    }

    void wyłącz() {
        System.out.println("Oświetlenie sufitowe kina: wyłączone");
    }

    void ściemniaj(int natężenie) {
        System.out.println("Oświetlenie sufitowe kina: " + natężenie);
    }
}
