package ShapesAbstractTest;

public class Deltoid extends Shape{

    private double przekatna1;
    private double przekatna2;

    public Deltoid(double d1, double d2) {
        this.przekatna1 = d1;
        this.przekatna2 = d2;
    }

    @Override
    protected void countArea() {
        super.area = 0.5 * przekatna1 * przekatna2;
    }

    public String toString() {
        return super.toString() + ", type: deltoid";
    }

    public static void main(String[] args) {
        Deltoid deltoid = new Deltoid(4.6, 4);
        System.out.println(deltoid.toString());
    }
}
