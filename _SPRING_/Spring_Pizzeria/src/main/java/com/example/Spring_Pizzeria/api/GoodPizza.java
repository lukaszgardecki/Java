package com.example.Spring_Pizzeria.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//      TWORZENIE WŁASNEJ ADNOTACJI
//      WYSTARCZY DODAĆ PONIŻSZE ADNOTACJE DO WŁASNEJ ADNOTACJI
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier

public @interface GoodPizza {

}
