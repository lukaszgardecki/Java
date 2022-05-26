package pl.am.podstawy.lekcja7;

import java.util.Random;

public class LiczbyLosowe {
    public static void main(String[] args) {
        Random generatorLiczbLosowych = new Random();

//        int losowyInt = generatorLiczbLosowych.nextInt();
//        System.out.println("losowyInt = " + losowyInt);
//
//        long losowyLong = generatorLiczbLosowych.nextLong();
//        System.out.println("losowyLong = " + losowyLong);
//
//        float losowyFloat = generatorLiczbLosowych.nextFloat();
//        System.out.println("losowyFloat = " + losowyFloat);
//
//        double losowyDouble = generatorLiczbLosowych.nextDouble();
//        System.out.println("losowyDouble = " + losowyDouble);
//
//        boolean losowyBoolean = generatorLiczbLosowych.nextBoolean();
//        System.out.println("losowyBoolean = " + losowyBoolean);



        for (int i = 1; i <= 100; i++) {
            int los = generatorLiczbLosowych.nextInt(5) + 1;
            System.out.println(i + ". " + los);
        }
    }
}
