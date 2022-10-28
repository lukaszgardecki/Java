package Zad_9_Kalkulator;

public class Calculate {
    public static void main(String[] args) {
        double x = 5;
        double y = 24;
        Calculator calculator = new Calculator();

        double addition = calculator.add(x, y);
        double subtraction = calculator.subtract(x, y);
        double multiplication = calculator.multiply(x, y);
        double division = calculator.divide(x, y);

        System.out.println("Dodawanie: " + addition);
        System.out.println("Odejmowanie: " + subtraction);
        System.out.println("Mno¿enie: " + multiplication);
        System.out.println("Dzielenie: " + division);
    }
}
