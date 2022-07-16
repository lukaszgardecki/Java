import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.

        if (x <= 0) {
            return f1(x);
        } else if (x > 0 && x < 1) {
            return f2(x);
        } else {
            return f3(x);
        }

    }

    //implement your methods here
    public static double f1(double x) {
        x = x * x + 1;
        return x;
    }

    public static double f2(double x) {
        x = 1 / (x * x);
        return x;
    }

    public static double f3(double x) {
        x = (x * x) - 1;
        return x;
    }
}