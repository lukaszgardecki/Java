import com.sun.security.jgss.GSSUtil;

public class Test {
    public static void main(String[] args) {


        System.out.println(">>> Pole prostokąta 2x2 [(0,0), (0,2), (2,2), (2,0)]:");
        Rectangle rectangle = new Rectangle(
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 2),
                new Point(2, 0)
        );
        double rectangleArea = Calculator.getRectangleArea(rectangle);
        System.out.println(rectangleArea);


        Point point = new Point(-1.5,-1.5);
        Circle circle = new Circle(new Point(0, 0), 2);
        System.out.printf(">>> Czy punkt o współrzędnych (%s,%s) znajduje się wewnątrz okręgu o środku w (%s,%s) i promieniu %s?%n",
                point.getX(),
                point.getY(),
                circle.getS().getX(),
                circle.getS().getY(),
                circle.getR()
        );
        String isPointInsideCircle = Calculator.isPointInsideCircle(point, circle);
        System.out.println(isPointInsideCircle);
    }
}
