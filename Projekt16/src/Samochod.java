public class Samochod extends Pojazd {
    boolean otwarty = false;
    void zamknijOtworz() {
        otwarty = !otwarty;
        if (otwarty)
            System.out.println("Otwarto");
        else
            System.out.println("Zamknięto");
    }

}
