public class Uczen {
    private String nazwisko;
    private int ocena;


    void setNazwisko(String nazwisko){
        if (nazwisko.length() >= 2) {
            this.nazwisko = nazwisko;
        }
    }

    String getNazwisko() {
        return "Nazwisko: " + this.nazwisko;
    }

    int getOcena() {
        return this.ocena;
    }

    void setOcena(int ocena){
        if (ocena >= 1 && ocena <= 6) {
            this.ocena = ocena;
        }
    }
}
