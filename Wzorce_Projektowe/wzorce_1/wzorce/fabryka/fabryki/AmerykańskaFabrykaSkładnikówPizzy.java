package wzorce.fabryka.fabryki;

import wzorce.fabryka.składniki.ciasto.Ciasto;
import wzorce.fabryka.składniki.ciasto.GrubeChrupkieCiasto;
import wzorce.fabryka.składniki.małże.Małże;
import wzorce.fabryka.składniki.małże.MrożoneMałże;
import wzorce.fabryka.składniki.pepperoni.Pepperoni;
import wzorce.fabryka.składniki.pepperoni.PlastryPepperoni;
import wzorce.fabryka.składniki.ser.Ser;
import wzorce.fabryka.składniki.ser.SerMozzarella;
import wzorce.fabryka.składniki.sos.Sos;
import wzorce.fabryka.składniki.sos.SosPomidorowy;
import wzorce.fabryka.składniki.warzywa.Bakłażan;
import wzorce.fabryka.składniki.warzywa.CzarneOliwki;
import wzorce.fabryka.składniki.warzywa.Szpinak;
import wzorce.fabryka.składniki.warzywa.Warzywa;

public class AmerykańskaFabrykaSkładnikówPizzy implements FabrykaSkładnikówPizzy {
    @Override
    public Ciasto utwórzCiasto() {
        return new GrubeChrupkieCiasto();
    }

    @Override
    public Sos utwórzSos() {
        return new SosPomidorowy();
    }

    @Override
    public Ser utwórzSer() {
        return new SerMozzarella();
    }

    @Override
    public Warzywa[] utwórzWarzywa() {
        return new Warzywa[]{new Bakłażan(), new Szpinak(), new CzarneOliwki()};
    }

    @Override
    public Pepperoni utwórzPepperoni() {
        return new PlastryPepperoni();
    }

    @Override
    public Małże utwórzMałże() {
        return new MrożoneMałże();
    }
}
