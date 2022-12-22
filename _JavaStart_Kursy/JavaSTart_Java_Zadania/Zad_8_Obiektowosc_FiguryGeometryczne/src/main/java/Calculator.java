public class Calculator {

    static double getRectangleArea(Rectangle rectangle) {
        double side1 = getSideLength(rectangle.getP1(), rectangle.getP2());
        double side2 = getSideLength(rectangle.getP2(), rectangle.getP3());
        return side1 * side2;
    }

    static String isPointInsideCircle(Point p, Circle circle) {
        double leftSideOfEquation = Math.pow(p.getX() - circle.getS().getX(), 2) + Math.pow(p.getY() - circle.getS().getY(), 2);
        double rightSideOfEquation = Math.pow(circle.getR(), 2);
        return leftSideOfEquation < rightSideOfEquation ? "TAK" : "NIE";
    }

    private static double getSideLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
    }
}
