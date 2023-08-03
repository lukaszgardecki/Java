package pl.am.oop.modyfikatory;

public class ModyfikatoryDostepu {
    public static void main(String[] args) {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski");

        pracownik.zwiekszPensje();

        System.out.println("pracownik = " + pracownik);
    }
}
