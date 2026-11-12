package wzorce.dekorator.Zadanie1.napoje;

public class Kawa implements Napoj {

    @Override
    public double koszt() {
        return 4.0;
    }

    @Override
    public String opis() {
        return "Kawa";
    }
}
