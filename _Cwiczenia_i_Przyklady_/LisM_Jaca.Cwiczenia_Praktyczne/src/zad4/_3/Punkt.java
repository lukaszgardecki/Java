package zad4._3;

public class Punkt {
    int x,y;

    void ustawWspolrzedne(int wspX, int wspY) {
        x = wspX;
        y = wspY;
    }

    Punkt pobierzWspolrzedne() {
        Punkt punkt = new Punkt();
        punkt.x = x;
        punkt.y = y;
        return punkt;
    }
}
