package Figury;

import Tablice.Ko�o;

public class Kszta�ty {
    public static void main(String[] args) {

        Prostokat prostokat = new Prostokat(2, 4);



        System.out.println("Prostok�t o bokach a=" + prostokat.getA() + ", b=" + prostokat.getB() + " posiada pole powierzchni wynosz�ce " + prostokat.obliczPole() + " obw�d wynosz�cy " + prostokat.obliczObwod() + ". Przek�tna tego prostok�ta wynosi " + prostokat.obliczPrzekatna() + ".");



    }
}
