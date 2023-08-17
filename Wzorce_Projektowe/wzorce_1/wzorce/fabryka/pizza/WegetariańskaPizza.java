package wzorce.fabryka.pizza;

import wzorce.fabryka.fabryki.FabrykaSkładnikówPizzy;

public class WegetariańskaPizza extends Pizza{
    private FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy;

    public WegetariańskaPizza(FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy) {
        this.fabrykaSkładnikówPizzy = fabrykaSkładnikówPizzy;
    }

    @Override
    public void przygotowanie() {
        System.out.println("Przygotowywanie: " + nazwa);
        ciasto = fabrykaSkładnikówPizzy.utwórzCiasto();
        sos = fabrykaSkładnikówPizzy.utwórzSos();
        ser = fabrykaSkładnikówPizzy.utwórzSer();
        warzywa = fabrykaSkładnikówPizzy.utwórzWarzywa();
    }
}
