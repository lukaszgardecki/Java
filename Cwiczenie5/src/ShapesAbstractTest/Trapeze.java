package ShapesAbstractTest;

public class Trapeze extends Shape{

    private double podstawa1;
    private double podstawa2;
    private double wysokosc;

    public Trapeze(double a, double b, double h) {
        this.podstawa1 = a;
        this.podstawa2 = b;
        this.wysokosc = h;
    }

    @Override
    protected void countArea() {
        super.area = ((podstawa1 + podstawa2)*wysokosc)/2;
    }

    public String toString() {
        return super.toString() + ", type: trapeze";
    }

    public static void main(String[] args) {
        Trapeze trapezik = new Trapeze(2, 3, 4);
        System.out.println(trapezik.toString());
    }
}
