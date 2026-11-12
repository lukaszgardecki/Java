package wzorce.dekorator.Zadanie1.napoje;

public class Herbata implements Napoj {

    @Override
    public double koszt() {
        return 3;
    }

    @Override
    public String opis() {
        return "Herbata";
    }
}
