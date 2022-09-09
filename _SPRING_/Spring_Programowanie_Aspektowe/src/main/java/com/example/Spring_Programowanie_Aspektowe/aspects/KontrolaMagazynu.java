package com.example.Spring_Programowanie_Aspektowe.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ASPEKTY. Oznaczamy klasę jako @Aspect, a następnie w tej klasie
 * definiujemy PORADY, wykonywane np. przed lub po głównej czynności
 */


@Aspect
public class KontrolaMagazynu {

    /**
     * Żeby nie wpisywać bardzo długiej ścieżki do każdej adnotacji możemy zrobić @Pointcut,
     * do którego raz wpisujemy ścieżkę. Jest to metoda. W kolejnych adnotacjach jeżeli
     * potrzebujemy użyć tej ścieżki - podajemy nazwę metody.
     */
    @Pointcut("execution(* com.example.Spring_Programowanie_Aspektowe.api.IKucharz.pobierzSkladnikiZMagazynu(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void sprawdzSkladnikiMagazynu() {
        System.out.println("Sprawdzam stan magazynu");
    }

    @AfterThrowing("pointCut()")
    public void zasyganlizujBrakiWMagazynie() {
        System.out.println("Braki w magazynie!");
    }
}
