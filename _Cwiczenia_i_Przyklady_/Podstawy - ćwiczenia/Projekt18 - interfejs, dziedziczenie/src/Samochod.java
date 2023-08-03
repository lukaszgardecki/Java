
//Interfejs trzeba zaimplementować słowem IMPLEMENTS + nazwa interfejsu
//Możemy implementować dowolną ilość interfejsów PO PRZECINKU

public class Samochod extends Pojazd implements Poruszanie, Comparable<String> {

    Samochod(String nazwa, int iloscKol) {
        //wywołujemy najpierw konstruktor bazowy
        super(nazwa);
        //dopiero potem dodatkowe rzeczy
        this.iloscKol = iloscKol;
    }
    int iloscKol;

    @Override
    public void jedzDoPrzodu() {
        System.out.println("Jade");
    }

    @Override
    public void skrecaj() {
        System.out.println("Skrecam");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
