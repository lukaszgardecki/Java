package com.example.Spring_Programowanie_Aspektowe.implementations;

import com.example.Spring_Programowanie_Aspektowe.api.IKucharz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Deprecated
public class PomocnikKucharza implements IKucharz {

    @Autowired
    @Qualifier("pomocnik_kucharza")
    private IKucharz kucharz;

    @Override
    public void pobierzSkladnikiZMagazynu(int liczbaSkladnikow) {
        System.out.println("Pomocnik pobiera " + liczbaSkladnikow + " składników");
    }

    @Override
    public void pobierzSkladnikiZMagazynu() {
        System.out.println("Pomocnik pobiera składniki z magazynu");
    }

    @Override
    public void przygotujPizze() {
        System.out.println("Pomocnik oddelegowuje przygotowanie pizzy do kucharza");
        kucharz.przygotujPizze();
    }

    @Override
    public void przygotujPizze(int idPizzy) {
        System.out.println("Pomocnik oddelegowuje przygotowanie pizzy o id " + idPizzy + " do kucharza");
        kucharz.przygotujPizze(idPizzy);
    }

    @Override
    public void wydajPizze() {
        System.out.println("Pomocnik wydaje pizzę");
    }
}
