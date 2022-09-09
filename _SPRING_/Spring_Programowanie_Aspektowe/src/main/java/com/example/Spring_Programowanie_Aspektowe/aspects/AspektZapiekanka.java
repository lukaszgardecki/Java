package com.example.Spring_Programowanie_Aspektowe.aspects;

import com.example.Spring_Programowanie_Aspektowe.api.InterfejsZapiekanka;
import com.example.Spring_Programowanie_Aspektowe.implementations.ImplZapiekanka;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class AspektZapiekanka {

    @DeclareParents(value = "com.example.Spring_Programowanie_Aspektowe.api.IKucharz+", defaultImpl = ImplZapiekanka.class)
    public static InterfejsZapiekanka izapiekanka;
}
