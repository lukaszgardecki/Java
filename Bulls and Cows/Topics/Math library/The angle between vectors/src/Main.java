import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double xa = scanner.nextDouble();
        double xb = scanner.nextDouble();
        double ya = scanner.nextDouble();
        double yb = scanner.nextDouble();
//        double xa = 0;
//        double xb = 4;
//        double ya = 0;
//        double yb = 4;
        double p1 = (xa * ya) + (xb * yb);

        double s1 = Math.sqrt(xa*xa + xb*xb);

        double s2 = Math.sqrt(ya*ya + yb*yb);
        double r = p1 / (s1*s2);
        double f = Math.acos(r);
        int ftg = (int) ((f*180)/Math.PI);

        System.out.println(ftg);
    }
}