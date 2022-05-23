public class Samochod extends Pojazd {

    Samochod(String marka, int iloscKol, int iloscDrzwi) {
        super(marka, iloscKol);
        this.iloscDrzwi = iloscDrzwi;
        System.out.println("Konstruktor klasy - Pojazd");
    }
    int iloscDrzwi;
    boolean otwarty = false;
    void zamknijOtworz() {
        otwarty = !otwarty;
        if (otwarty)
            System.out.println("Otwarto");
        else
            System.out.println("Zamknięto");
    }

}
