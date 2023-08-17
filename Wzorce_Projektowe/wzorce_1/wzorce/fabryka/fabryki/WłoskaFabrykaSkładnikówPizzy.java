package wzorce.fabryka.fabryki;

import wzorce.fabryka.składniki.ciasto.Ciasto;
import wzorce.fabryka.składniki.ciasto.CienkieChrupkieCiasto;
import wzorce.fabryka.składniki.małże.Małże;
import wzorce.fabryka.składniki.małże.ŚwieżeMałże;
import wzorce.fabryka.składniki.pepperoni.Pepperoni;
import wzorce.fabryka.składniki.pepperoni.PlastryPepperoni;
import wzorce.fabryka.składniki.ser.Ser;
import wzorce.fabryka.składniki.ser.SerReggiano;
import wzorce.fabryka.składniki.sos.Sos;
import wzorce.fabryka.składniki.sos.SosMarinara;
import wzorce.fabryka.składniki.warzywa.*;

public class WłoskaFabrykaSkładnikówPizzy implements FabrykaSkładnikówPizzy {
    @Override
    public Ciasto utwórzCiasto() {
        return new CienkieChrupkieCiasto();
    }

    @Override
    public Sos utwórzSos() {
        return new SosMarinara();
    }

    @Override
    public Ser utwórzSer() {
        return new SerReggiano();
    }

    @Override
    public Warzywa[] utwórzWarzywa() {
        return new Warzywa[]{new Czosnek(), new Cebula(), new Pieczarki(), new CzerwonaPapryka()};
    }

    @Override
    public Pepperoni utwórzPepperoni() {
        return new PlastryPepperoni();
    }

    @Override
    public Małże utwórzMałże() {
        return new ŚwieżeMałże();
    }
}
