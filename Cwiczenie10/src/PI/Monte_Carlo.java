package PI;

public class Monte_Carlo {
    public static void main(String[] args) {
        double r1, r2;
        int i, m=0, n=10000;
        for (i = 1; i <= n; i++) {
            r1=Math.random()-0.5;
            r2=Math.random()-0.5;
            if (r1*r1+r2*r2 < 0.25) m++;
        }
        System.out.println("PI oszacowane = " + 4.0 * (double) m / n);
        System.out.println("PI z Math.PI = " + Math.PI);
    }
}
