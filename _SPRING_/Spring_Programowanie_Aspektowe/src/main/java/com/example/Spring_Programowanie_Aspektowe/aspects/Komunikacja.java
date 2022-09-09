package com.example.Spring_Programowanie_Aspektowe.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Komunikacja {

    @Pointcut("args(argumentInt)")
    public void pointcutInt(int argumentInt) {
    }

    @Pointcut("target(com.example.Spring_Programowanie_Aspektowe.api.IKucharz)")
    public void pointcutTarget() {
    }

    @Pointcut("@target(annotation)")
    public void pointcutTargetAnnotation(Deprecated annotation) {
    }

    @Pointcut("within(com.example.Spring_Programowanie_Aspektowe.implementations.Kucharz)")
    public void pointcutWithin() {
    }

    @Before("!pointcutWithin() && pointcutInt(arg)")
    public void porada(int arg) {
        System.out.println("PORADA ");
    }








//    @After("execution(* com.example.Spring_Programowanie_Aspektowe.api.IKucharz.pobierzSkladnikiZMagazynu(..))")
//    public void poinformujOPobraniuSkladnikow() {
//        System.out.println("Pobrano składniki");
//    }
//
//    @Around("execution(* com.example.Spring_Programowanie_Aspektowe.api.IKucharz.wydajPizze(..))")
//    public void wydaniePizzy(ProceedingJoinPoint joinPoint) {
//        try {
//            System.out.println("KOMUNIKUJEMY, ŻE PIZZA JEST GOTOWA");
//            joinPoint.proceed();
//            System.out.println("KOMUNIKUJEMY, ŻE WYDANO PIZZĘ");
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
}
