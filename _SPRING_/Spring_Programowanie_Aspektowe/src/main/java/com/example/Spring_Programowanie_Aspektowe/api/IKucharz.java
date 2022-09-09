package com.example.Spring_Programowanie_Aspektowe.api;

public interface IKucharz {
    void pobierzSkladnikiZMagazynu(int liczbaSkladnikow);
    void pobierzSkladnikiZMagazynu();
    void przygotujPizze();
    void przygotujPizze(int idPizzy);
    void wydajPizze();
}
