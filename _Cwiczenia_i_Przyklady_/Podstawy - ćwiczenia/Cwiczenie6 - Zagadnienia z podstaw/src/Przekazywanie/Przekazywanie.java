package Przekazywanie;

//Przekazywanie parametr�w do metod

public class Przekazywanie {

    public static void podwojenie(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * 2;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[1];
        x[0] = 10;
        System.out.println("Warto�� x przed podwojeniem " + x[0]);

        podwojenie(x);
        System.out.println("Warto�� x po podwojeniu " + x[0]);
    }
}
