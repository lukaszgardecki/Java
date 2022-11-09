package Zad_51_Rekurencja;

class Rekurencja {
    public static void main(String[] args) {
        int num = 3;
        System.out.println("Silnia z liczby " + num + " to " + countFactorial(num));
    }

    private static int countFactorial(int num) {
        return num > 1 ? num * countFactorial(num - 1) : 1;
    }
}
