package wzorce.dekorator;

import wzorce.dekorator.dekoratory.BitaŚmietana;
import wzorce.dekorator.dekoratory.Czekolada;
import wzorce.dekorator.dekoratory.MleczkoSojowe;
import wzorce.dekorator.składnikiGłówne.Espresso;
import wzorce.dekorator.składnikiGłówne.MocnoPalona;
import wzorce.dekorator.składnikiGłówne.Napój;
import wzorce.dekorator.składnikiGłówne.StarCafeSpecial;

public class StarCafe {
    public static void main(String[] args) {
        Napój napój = new Espresso();
        napój.ustawWielkość(Napój.MAŁY);
        System.out.println(napój.pobierzOpis() + " " + napój.koszt() + "zł");

        Napój napój2 = new MocnoPalona();
        napój2.ustawWielkość(Napój.DUŻY);
        napój2 = new Czekolada(napój2);
        napój2 = new Czekolada(napój2);
        napój2 = new BitaŚmietana(napój2);
        System.out.println(napój2.pobierzOpis() + " " + napój2.koszt() + "zł");

        Napój napój3 = new StarCafeSpecial();
        napój3.ustawWielkość(Napój.ŚREDNI);
        napój3 = new MleczkoSojowe(napój3);
        napój3 = new Czekolada(napój3);
        napój3 = new BitaŚmietana(napój3);
        System.out.println(napój3.pobierzOpis() + " " + napój3.koszt() + "zł");


    }
}
