package Figury;

import Tablice.Ko³o;

public class Kszta³ty {
    public static void main(String[] args) {

        Prostokat prostokat = new Prostokat(2, 4);



        System.out.println("Prostok¹t o bokach a=" + prostokat.getA() + ", b=" + prostokat.getB() + " posiada pole powierzchni wynosz¹ce " + prostokat.obliczPole() + " obwód wynosz¹cy " + prostokat.obliczObwod() + ". Przek¹tna tego prostok¹ta wynosi " + prostokat.obliczPrzekatna() + ".");



    }
}
