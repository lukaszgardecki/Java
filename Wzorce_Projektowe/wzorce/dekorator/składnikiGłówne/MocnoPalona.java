package wzorce.dekorator.składnikiGłówne;

public class MocnoPalona extends Napój {

    public MocnoPalona() {
        opis = "Kawa Mocno Palona";
    }

    @Override
    public double koszt() {
        return 0.99;
    }
}
