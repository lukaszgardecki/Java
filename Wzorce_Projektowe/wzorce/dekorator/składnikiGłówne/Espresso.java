package wzorce.dekorator.składnikiGłówne;

public class Espresso extends Napój {

    public Espresso() {
        opis = "Kawa Espresso";
    }

    @Override
    public double koszt() {
        return 1.99;
    }

    @Override
    public void ustawWielkość(int wielkość) {
        this.wielkość = wielkość;
    }

}
