package pl.am.oop.pamiec;

public class ArgumentyMetodyZlozone {



    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski");
        pracownik1.pensja = 2000;

//        zwiekszPensje(pracownik1);
        pracownik1.zwiekszPensje();

        System.out.println("pracownik1 = " + pracownik1);
    }
}
