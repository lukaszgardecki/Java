import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.next();
        double area = 0, a = 0, b = 0, c = 0, r = 0, p = 0;


        switch (shape) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                p = 0.5 * (a + b + c);
                area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(area);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                area = a * b;
                System.out.println(area);
                break;
            case "circle":
                r = scanner.nextDouble();
                area = 3.14 * r * r;
                System.out.println(area);
        }
    }
}