package com.example.Spring_Programowanie_Aspektowe.implementations;

import com.example.Spring_Programowanie_Aspektowe.api.IKucharz;

public class Kucharz implements IKucharz {
    @Override
    public void pobierzSkladnikiZMagazynu(int liczbaSkladnikow) {
        System.out.println("Kucharz pobiera " + liczbaSkladnikow + " składników");
    }

    @Override
    public void pobierzSkladnikiZMagazynu() {
        System.out.println("Kucharz pobiera składniki.");
    }

    @Override
    public void przygotujPizze() {
        System.out.println("Kucharz przygotowuje pizzę.");
    }

    @Override
    public void przygotujPizze(int idPizzy) {
        System.out.println("Kucharz przygotowuje pizzę o id " + idPizzy);
    }

    @Override
    public void wydajPizze() {
        System.out.println("Kucharz wydaje pizzę.");
    }
}
