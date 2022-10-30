package Zad_23_Kalkulator3;

class Calc {

    double doOperation(double num1, double num2, String sign) {
        double num = 0;
        switch (sign) {
            case "+" -> num = num1 + num2;
            case "-" -> num = num1 - num2;
            case "*" -> num = num1 * num2;
            case "/" -> {
                if (num2 != 0) num = num1 / num2;
            }
        }
        return num;
    }
}
