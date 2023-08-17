package wzorce.proxy.ćwiczenie;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class BiuroMatrymonialneTest {
    public static void main(String[] args) {
        BiuroMatrymonialneTest test = new BiuroMatrymonialneTest();
        test.testuj();
    }

    public BiuroMatrymonialneTest() {
        inicjalizujBD();
    }

    private void testuj() {
        OsobaKomponent jasiu = pobierzZBazyDanych("Jaś Fasola");

        OsobaKomponent pośrednikWłaściciela = pobierzPośrednikWłaściciela(jasiu);
        System.out.println("Imię to " + pośrednikWłaściciela.pobierzImię());
        pośrednikWłaściciela.ustawZainteresowania("kręgle, Go");
        System.out.println("Pośrednik właściciela ustawił wartość zainteresowania");
        try {
            pośrednikWłaściciela.ustawRankingUrody(10);
        } catch (Exception e) {
            System.out.println("Nie można zmieniać oceny przy użyciu pośrednika właściciela");
        }
        System.out.println("Ocena to " + pośrednikWłaściciela.pobierzRankingUrody());

        OsobaKomponent pośrednikNieWłaściciela = pobierzPośrednikNieWłaściciela(jasiu);
        System.out.println("Imię to " + pośrednikNieWłaściciela.pobierzImię());
        try {
            pośrednikNieWłaściciela.ustawZainteresowania("kręgle, Go");
        } catch (Exception e) {
            System.out.println("Nie można zmieniać zainteresowań przy użyciu pośrednika obcego");
        }
        pośrednikNieWłaściciela.ustawRankingUrody(3);
        System.out.println("Pośrednik obcy zmienił wartość oceny");
        System.out.println("Ocena to " + pośrednikNieWłaściciela.pobierzRankingUrody());
    }

    private OsobaKomponent pobierzZBazyDanych(String o) {
        OsobaKomponent osoba = new OsobaKomponentImpl();
        osoba.ustawImię(o);
        return osoba;
    }

    private void inicjalizujBD() {

    }

    static OsobaKomponent pobierzPośrednikWłaściciela(OsobaKomponent osoba) {
        return (OsobaKomponent) Proxy.newProxyInstance(
                osoba.getClass().getClassLoader(),
                osoba.getClass().getInterfaces(),
                new InvocationHandlerWłaściciela(osoba)
        );
    }

    static OsobaKomponent pobierzPośrednikNieWłaściciela(OsobaKomponent osoba) {
        return (OsobaKomponent) Proxy.newProxyInstance(
                osoba.getClass().getClassLoader(),
                osoba.getClass().getInterfaces(),
                new InvocationHandlerNieWłaściciela(osoba)
        );
    }

    static OsobaKomponent pobierzPośrednik(InvocationHandler invocationHandler, OsobaKomponent osoba) {
        boolean jestWłaścicielem = invocationHandler instanceof InvocationHandlerWłaściciela;
        InvocationHandler invHand = jestWłaścicielem ? new InvocationHandlerWłaściciela(osoba)
                                  : new InvocationHandlerNieWłaściciela(osoba);

        return (OsobaKomponent) Proxy.newProxyInstance(
                osoba.getClass().getClassLoader(),
                osoba.getClass().getInterfaces(),
                invHand
        );
    }

}