package pl.am.oop.hermetyzacja2;

public class Punkt {

    //ukrywanie danych z których z³o¿ona jest klaasa jest porz¹danym zjawiskiem. Dlatego dajemy PRIVATE
    //reprezentacja punktów w postaci kartezjañskiej:
    private double x;
    private double y;

    public void setKartezjusz(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPolarne(double r, double fi) {
        this.x = r * Math.cos(fi);
        this.y = r * Math.sin(fi);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double getFi() {
        return Math.atan(this.y / this.x);
    }

    public String toString() {
        return "x: " + this.x + ", y: " + this.y + ", r: " + this.getR() + ", fi: " + this.getFi();
    }
}
