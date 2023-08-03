package pl.am.oop.konstruowanie;

public class Pracownik {
    //sta³a statyczna. sta³e oznaczamy "final" i nazwê piszemy z wielkich liter
    public static final String NAZWA_FIRMY = "Us³ugi wszelakie";
    //zmienna statyczna:
    private static int nextId =0;
    private int id = /*ustawId(); lub: */ ++nextId;
    private final String imie;
    private String nazwisko;
    private String stanowisko = "robotnik";
    private int wiek;
    private double pensja = 2600;
    private boolean zaliczoneBHP;

//    //blok inicjalizuj¹cy. Raczej nie zaleca siê ich stosowania. Ale trzeba wiedzieæ, ¿e istniej¹ i w razie wyst¹pienia, wiedzieæ czym s¹. W tym przypadku blok inizjalizuj¹cy nadpisuje pensjê zadeklarowan¹ wy¿ej.
//    {
//        this.pensja = 4000;
//    }
//    //statyczne bloki inicjalizuj¹ce
//    static {
//        nextId = 0;
//    }



    //Stwórzmy konstruktor, ¿eby w klasie Firma wpisywaæ dane o pracowniku na etapie tworzenia nowego pracownika, czyli w nawiasie ju¿. Je¿eli tutaj nie stworzymy konstruktora, to w klasie Firma mo¿emy stworzyæ nowych pracowników, a dopiero póŸniej mo¿emy im rêcznie przypisywaæ imie, nazwisko, wiek itp...
//    public Pracownik(String imie, String nazwisko, int wiek) {
//        this.imie = imie;
//        this.nazwisko = nazwisko;
//        this.wiek = wiek;
//
//    }

    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

    }

    //Mo¿emy równie¿ w konstruktorze wywo³aæ inny konstruktor, np. jeœli dane siê pokrywaj¹ i ró¿ni¹ siê one kilkoma elementami:
    public Pracownik(String imie, String nazwisko, int wiek) {
        this(imie, nazwisko); // <----to wywo³anie MUSI byæ pierwsz¹ instrukcj¹ !
        this.wiek = wiek;
    }

//    private int ustawId() {
//        //wersja 1:
////        nextId++;
////        return nextId;
//        //lub wersja 2:
////        return ++nextId;
//
//    }

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
        String infoPracownik = "Pracownik: " + this.getNazwa() + ", id: " + this.id + ", wiek: " + this.wiek + ", zarabia: " + this.pensja;

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
            System.out.println("Nie mo¿na ustawiæ nazwiska na pusty ³añcuch znaków");
        } else {
            this.nazwisko = noweNazwisko;
        }

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

    public static String infoFirma() {
        return "Firma: " + NAZWA_FIRMY + " zatrudnia " + nextId + " pracowników.";
    }
}
