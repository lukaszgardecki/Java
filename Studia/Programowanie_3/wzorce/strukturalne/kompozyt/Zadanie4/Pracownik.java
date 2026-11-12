package wzorce.strukturalne.kompozyt.Zadanie4;

public class Pracownik implements ElementOrganizacji {
    private String imie;
    private double pensja;

    public Pracownik(String imie, double pensja) {
        this.imie = imie;
        this.pensja = pensja;
    }

    @Override
    public double pobierzPensje() {
        return pensja;
    }

    @Override
    public void wypiszHierarchie(String wciecie) {
        System.out.println(wciecie + imie + " (" + pensja + ")");
    }
}
