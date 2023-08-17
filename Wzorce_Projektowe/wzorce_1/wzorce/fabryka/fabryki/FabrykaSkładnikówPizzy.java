package wzorce.fabryka.fabryki;

import wzorce.fabryka.składniki.ciasto.Ciasto;
import wzorce.fabryka.składniki.małże.Małże;
import wzorce.fabryka.składniki.pepperoni.Pepperoni;
import wzorce.fabryka.składniki.ser.Ser;
import wzorce.fabryka.składniki.sos.Sos;
import wzorce.fabryka.składniki.warzywa.Warzywa;

public interface FabrykaSkładnikówPizzy {
    /*
    FabrykaSkałdnikówPizzy została zaimplementowana jako FABRYKA ABSTRAKCYJNA,
    ponieważ zapewnia interfejs abstrakcyjny umożliwiający tworzeni CAŁEJ RODZINY PRODUKTÓW.

    Każda rzeczywista klasa podrzędna tworzy całą rodzinę produktów.
    */

    Ciasto utwórzCiasto();
    Sos utwórzSos();
    Ser utwórzSer();
    Warzywa[] utwórzWarzywa();
    Pepperoni utwórzPepperoni();
    Małże utwórzMałże();
}
