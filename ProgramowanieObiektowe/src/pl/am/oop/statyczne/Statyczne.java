package pl.am.oop.statyczne;

import java.util.Random;

//import statyczny:
import static java.lang.Math.PI;
import static java.lang.Math.max;

public class Statyczne {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(max(1, 5));
        System.out.println(PI);
    }
}
