package pl.am.oop.hermetyzacja;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private int wiek;
    private double pensja;
    private boolean zaliczoneBHP;

    //Stw�rzmy konstruktor, �eby w klasie Firma wpisywa� dane o pracowniku na etapie tworzenia nowego pracownika, czyli w nawiasie ju�. Je�eli tutaj nie stworzymy konstruktora, to w klasie Firma mo�emy stworzy� nowych pracownik�w, a dopiero p�niej mo�emy im r�cznie przypisywa� imie, nazwisko, wiek itp...
    public Pracownik(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pensja = 3000;
    }
    public Pracownik(String imie, String nazwisko) {
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

    public void zwiekszPensje() {
        this.pensja = 1.15 * this.pensja;
    }


}
