package pl.am.oop.rzutowanie;

public class TypyProste {
    public static void main(String[] args) {
        int zmiennaInt = 6;
        short zmiennaShort = (short)zmiennaInt; // <--- rzutowanie,tutaj przypisanie zmiennej o wiêkszym zakresie do zmiennej o mniejszym zakresie, zmiennaInt mo¿e nie zmieœciæ siê w zmiennaShort, wiêc musimy napisaæ, ¿e my wiemy o tym ale deklarujemy, ¿e zmiennaInt nie przekroczy pojemnoœci zmiennaShort. W tym celu musimy wykonaæ rzutowanie i wstawiæ nawiasy

        long zmiennalong = zmiennaInt;
        byte zmiennaByte = (byte) zmiennaInt;

        int zmienna2 = 10000000;

        float zmiennaFloat = zmiennalong;
        double zmiennaDouble = zmiennalong;

        zmiennalong = (long)zmiennaFloat;
        zmiennaInt = (int)zmiennaDouble;

    }
}
