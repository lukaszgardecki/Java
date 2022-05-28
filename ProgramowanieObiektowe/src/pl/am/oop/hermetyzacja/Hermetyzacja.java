package pl.am.oop.hermetyzacja;

public class Hermetyzacja {
    public static void main(String[] args) {
        Pracownik pracownik = new Pracownik("Anna", "Nowak");

        pracownik.setNazwisko("kowal");

        System.out.println(pracownik.getNazwa());

        System.out.println("pracownik = " + pracownik);
    }
}
