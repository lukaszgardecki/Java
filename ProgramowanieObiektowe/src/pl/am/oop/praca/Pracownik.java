package pl.am.oop.praca;

public class Pracownik {
    String imie;
    String nazwisko;
    int wiek;
    double pensja;
    boolean zaliczoneBHP;

    //Stwórzmy konstruktor, ¿eby w klasie Firma wpisywaæ dane o pracowniku na etapie tworzenia nowego pracownika, czyli w nawiasie ju¿. Je¿eli tutaj nie stworzymy konstruktora, to w klasie Firma mo¿emy stworzyæ nowych pracowników, a dopiero póŸniej mo¿emy im rêcznie przypisywaæ imie, nazwisko, wiek itp...
    Pracownik(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pensja = 3000;
    }
    Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = 3000;
    }

//    public static String info(Pracownik pracownik) {
//        String infoPracownik = "Pracownik: " + pracownik.imie + " " + pracownik.nazwisko + ", wiek: " + pracownik.wiek + ", zarabia: " + pracownik.pensja;
//
//        if (pracownik.zaliczoneBHP) {
//            infoPracownik += ", zaliczone BHP";
//        } else {
//            infoPracownik += ", NIE zaliczone BHP";
//        }
//        return infoPracownik;
//    }

    public String toString() {
        String infoPracownik = "Pracownik: " + this.imie + " " + this.nazwisko + ", wiek: " + this.wiek + ", zarabia: " + this.pensja;

        if (this.zaliczoneBHP) {
            infoPracownik += ", zaliczone BHP";
        } else {
            infoPracownik += ", NIE zaliczone BHP";
        }
        return infoPracownik;
    }


}
