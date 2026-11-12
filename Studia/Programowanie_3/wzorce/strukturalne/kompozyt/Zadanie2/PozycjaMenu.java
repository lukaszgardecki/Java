package wzorce.strukturalne.kompozyt.Zadanie2;

public class PozycjaMenu implements  ElementMenu {
    private String etykieta;

    public PozycjaMenu(String etykieta) {
        this.etykieta = etykieta;
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "- " + etykieta);
    }
}
