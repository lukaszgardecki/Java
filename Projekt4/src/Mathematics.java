public class Mathematics {
    public static void main(String[] args) {
        Mathematics m = new Mathematics();

        m.className(); //wywołanie className
        System.out.println(m.sqrt(5));
        System.out.println(m.sqrt(3));
        System.out.println(m.sqrt(24));
        System.out.println(m.sqrt(55.345));
    }
    public void className() {
        System.out.println("Matematyka");
    }
    public int sqrt(int a) {
        return a * a;
    }

    public double sqrt(double a) {
        return a * a;
    }
}
