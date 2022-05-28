package pl.am.oop.konstruowanie;

public class Konstruowanie {
    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski");
        Pracownik pracownik2 = new Pracownik("Wojciech", "Nowak", 55);

        System.out.println(pracownik1);
        System.out.println(pracownik2);

        System.out.println(Pracownik.infoFirma());
    }
}
