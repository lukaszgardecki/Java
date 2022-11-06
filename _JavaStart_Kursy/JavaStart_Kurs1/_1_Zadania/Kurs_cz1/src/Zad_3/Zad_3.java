package Zad_3;

import java.util.Random;

class Zad_3 {
    public static void main(String[] args) {
        Random random = new Random();

        int x = random.nextInt(50);
        int y = random.nextInt(30);

        boolean result1 = x > y;
        System.out.printf("Czy x=%d jest wiêksze od y=%d? %b\n", x, y, result1);

        boolean result2 = x*2 > y;
        System.out.printf("Czy x=%d*2 jest wiêksze od y=%d? %b\n", x, y, result2);

        boolean result3 = y < (x+3) && y > (x-2);
        System.out.printf("Czy y=%d jest mniejsze od x=%d+2 i jednoczeœnie wiêksze od x=%d-2 ? %b\n", y, x, x, result3);

        boolean result4 = (x*y) % 2 == 0;
        System.out.printf("Czy iloczyn x=%d i y=%d jest parzysty? %b\n", x, y, result4);

    }
}
