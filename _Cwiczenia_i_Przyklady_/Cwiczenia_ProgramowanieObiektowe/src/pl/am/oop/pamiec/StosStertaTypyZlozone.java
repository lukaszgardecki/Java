package pl.am.oop.pamiec;

public class StosStertaTypyZlozone {
    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski");
        Pracownik pracownik2 = pracownik1;

        System.out.println("pracownik1 = " + pracownik1);
        System.out.println("pracownik2 = " + pracownik2);
    }
}
