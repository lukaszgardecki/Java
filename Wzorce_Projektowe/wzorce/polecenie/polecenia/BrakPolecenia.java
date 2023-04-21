package wzorce.polecenie.polecenia;

public class BrakPolecenia implements Polecenie{

    @Override
    public void wykonaj() {
        System.out.println("Brak polecenia");
    }

    @Override
    public void wycofaj() {
        System.out.println("Brak polecenia");
    }
}
