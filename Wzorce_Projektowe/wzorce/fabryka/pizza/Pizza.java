package wzorce.fabryka.pizza;

import wzorce.fabryka.składniki.ciasto.Ciasto;
import wzorce.fabryka.składniki.małże.Małże;
import wzorce.fabryka.składniki.pepperoni.Pepperoni;
import wzorce.fabryka.składniki.ser.Ser;
import wzorce.fabryka.składniki.sos.Sos;
import wzorce.fabryka.składniki.warzywa.Warzywa;

import java.util.Arrays;

public abstract class Pizza {
    protected String nazwa;
    protected Ciasto ciasto;
    protected Sos sos;
    protected Warzywa[] warzywa;
    protected Ser ser;
    protected Pepperoni pepperoni;
    protected Małże małże;

    public abstract void przygotowanie();

    public void pieczenie() {
        System.out.println("Pieczenie: 25 minut w temperaturze 180 stopni Celsjusza");
    }

    public void krojenie() {
        System.out.println("Krojenie pizzy na 8 kawałków");
    }

    public void pakowanie() {
        System.out.println("Pakowanie pizzy w oficjalne pudełko naszej sieci Pizzerii.");
    }

    public String pobierzNazwa() {
        return nazwa;
    }

    public void ustawNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nazwa='" + nazwa + '\'' +
                ", ciasto='" + ciasto + '\'' +
                ", sos='" + sos + '\'' +
                ", warzywa=" + Arrays.toString(warzywa) +
                ", ser=" + ser +
                ", pepperoni=" + pepperoni +
                ", małże=" + małże +
                '}';
    }
}
