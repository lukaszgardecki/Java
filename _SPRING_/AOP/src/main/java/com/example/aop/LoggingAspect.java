package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {


    // Gdy będziesz wykonywać metodę checkout() z klasy ShoppingCart to przedtem wykonaj poniższą metodę
    @Before("execution(* ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
//        System.out.println(jp.getSignature());
//        System.out.println(Arrays.toString(jp.getArgs()));
        System.out.println("Before Logger");
    }

    // Gdy będziesz wykonywać metodę checkout() z klasy ShoppingCart to po niej wykonaj poniższą metodę
    @After("execution(* ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }

    @Pointcut("execution(* ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {}

    // Gdy będziesz wykonywać metodę quantity() z klasy ShoppingCart to po zwróceniu przez nią wartości wykonaj poniższą metodę
    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning: " + retVal);
    }
}
