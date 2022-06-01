package ShapesAbstractTest;

public class Rectangle extends Shape {

    private double bok1;
    private double bok2;

    public Rectangle(double a, double b) {
        this.bok1 = a;
        this.bok2 = b;
    }

    @Override
    protected void countArea() {
        super.area = bok1 * bok2;
    }

    public String toString() {
        return super.toString() + ", type: rectangle";
    }

    public static void main(String[] args) {
        Rectangle kwadracik = new Rectangle(4, 6);
        System.out.println(kwadracik.toString());
    }
}
