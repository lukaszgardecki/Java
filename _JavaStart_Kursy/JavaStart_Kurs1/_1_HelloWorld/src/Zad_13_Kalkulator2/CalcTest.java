package Zad_13_Kalkulator2;

class CalcTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double result1 = calculator.add(2, 3);
        double result2 = calculator.add(4, 3, 2);
        double result3 = calculator.subtract(7, 2, 1);
        double result4 = calculator.subtract(8, 4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
