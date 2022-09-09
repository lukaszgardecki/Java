package com.example.Spring_Programowanie_Aspektowe.implementations;

import com.example.Spring_Programowanie_Aspektowe.api.InterfejsZapiekanka;

public class ImplZapiekanka implements InterfejsZapiekanka {

    @Override
    public void przygotujZapiekanke() {
        System.out.println("Kucharz przygotowuje zapiekankę");
    }
}
