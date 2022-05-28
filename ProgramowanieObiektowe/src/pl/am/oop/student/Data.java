package pl.am.oop.student;

public class Data {
    private int rok;
    private int miesiac;
    private int dzien;

    public Data(int rok, int miesiac, int dzien) {
        this.rok = rok;
        this.miesiac = miesiac;
        this.dzien = dzien;
    }

    @Override
    public String toString() {
        return "Data{" +
                "rok=" + rok +
                ", miesiac=" + miesiac +
                ", dzien=" + dzien +
                '}';
    }
}
