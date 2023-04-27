package wzorce.proxy.ćwiczenie;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandlerNieWłaściciela implements InvocationHandler {
    private OsobaKomponent osoba;

    public InvocationHandlerNieWłaściciela(OsobaKomponent osoba) {
        this.osoba = osoba;
    }

    @Override
    public Object invoke(Object pośrednik, Method metoda, Object[] argumenty) throws IllegalAccessException {
        try {
            if (metoda.getName().startsWith("pobierz")) {
                return metoda.invoke(osoba, argumenty);
            } else if (metoda.getName().equals("ustawRankingUrody")) {
                return metoda.invoke(osoba, argumenty);
            } else if (metoda.getName().startsWith("ustaw")) {
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
