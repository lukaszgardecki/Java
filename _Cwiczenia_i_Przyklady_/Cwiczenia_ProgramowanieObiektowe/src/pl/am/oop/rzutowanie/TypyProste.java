package pl.am.oop.rzutowanie;

public class TypyProste {
    public static void main(String[] args) {
        int zmiennaInt = 6;
        short zmiennaShort = (short)zmiennaInt; // <--- rzutowanie,tutaj przypisanie zmiennej o wi�kszym zakresie do zmiennej o mniejszym zakresie, zmiennaInt mo�e nie zmie�ci� si� w zmiennaShort, wi�c musimy napisa�, �e my wiemy o tym ale deklarujemy, �e zmiennaInt nie przekroczy pojemno�ci zmiennaShort. W tym celu musimy wykona� rzutowanie i wstawi� nawiasy

        long zmiennalong = zmiennaInt;
        byte zmiennaByte = (byte) zmiennaInt;

        int zmienna2 = 10000000;

        float zmiennaFloat = zmiennalong;
        double zmiennaDouble = zmiennalong;

        zmiennalong = (long)zmiennaFloat;
        zmiennaInt = (int)zmiennaDouble;

    }
}
