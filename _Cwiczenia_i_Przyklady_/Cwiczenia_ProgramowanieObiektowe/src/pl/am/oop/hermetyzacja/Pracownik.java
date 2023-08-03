package pl.am.oop.hermetyzacja;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private int wiek;
    private double pensja;
    private boolean zaliczoneBHP;

    //Stw�rzmy konstruktor, �eby w klasie Firma wpisywa� dane o pracowniku na etapie tworzenia nowego pracownika, czyli w nawiasie ju�. Je�eli tutaj nie stworzymy konstruktora, to w klasie Firma mo�emy stworzy� nowych pracownik�w, a dopiero p�niej mo�emy im r�cznie przypisywa� imie, nazwisko, wiek itp...
    public Pracownik(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pensja = 3000;
        this.stanowisko = "pomocnik";
    }
    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = 3000;
        this.stanowisko = "pomocnik";
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

    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNazwa() {
        return this.stanowisko + " " + this.imie + " " + this.nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public double getPensja() {
        return pensja;
    }

    public boolean isZaliczoneBHP() {
        return zaliczoneBHP;
    }

    public void setNazwisko(String noweNazwisko) {
        if (noweNazwisko == null || noweNazwisko.equals("")) {
            System.out.println("Nie mo�na ustawi� nazwiska na pusty �a�cuch znak�w");
        } else {
            this.nazwisko = noweNazwisko;
        }

    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public void setZaliczoneBHP(boolean zaliczoneBHP) {
        this.zaliczoneBHP = zaliczoneBHP;
    }
}
