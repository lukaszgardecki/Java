package wzorce.strukturalne.kompozyt.Zadanie1PPP;

public class Zadanie1PPP {
    public static void main(String[] args) {
        Plik p1 = new Plik("1.f", 2345f);
        Plik p2 = new Plik("2.f", 2345f);
        Plik p3 = new Plik("3.f", 2345f);

        Katalog k1 = new Katalog("katalog1");
        Katalog k2 = new Katalog("katalog2");

        k1.dodaj(p1);
        k1.dodaj(p2);

        k2.dodaj(p2);
        k2.dodaj(p3);

        k1.dodaj(k2);

        k1.wypisz("");
        float v = k1.pobierzRozmiar();
        System.out.println("Rozmiar " + v);
    }
}
