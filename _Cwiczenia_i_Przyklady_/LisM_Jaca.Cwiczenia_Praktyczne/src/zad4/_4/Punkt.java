package zad4._4;

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

    void ustawX(int wspX) {
        x = wspX;
    }
    void ustawY(int wspY) {
        y = wspY;
    }

    int pobierzX() {
        return x;
    }
    int pobierzY() {
        return y;
    }
}
