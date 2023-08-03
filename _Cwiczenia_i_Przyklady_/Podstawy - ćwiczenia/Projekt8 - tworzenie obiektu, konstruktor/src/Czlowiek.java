public class Czlowiek {

    //Konstruktorów może być więcej niż jeden, tzn. mogą być przeciążone. Aby mogły istnieć dwa te same konstruktory to ,uszą się różnić ilością ragumentów lub typem tych argumentów.
    Czlowiek() {
        liczebnosc++;
    }
    Czlowiek(String imie) {
        this.imie = imie;
        liczebnosc++;
    }
    public String imie;
    static int liczebnosc = 0; //
}
