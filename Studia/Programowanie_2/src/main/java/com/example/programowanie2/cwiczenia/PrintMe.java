package com.example.programowanie2.cwiczenia;

class PrintMe {


    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z1 = x+++ ++y;
        int z2 = ++x+y++;

        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);

        double a=1;
        a=a/-0.0;
        System.out.println(a);

        float f1 = -343;

        new PrintMe().dod('A');

        // odwracanie stringa szybkie
        String str = "DUPA";
        String reversed = new StringBuilder(str).reverse().toString();

        // odwracanie stringa na piechotę (niewydajne)
        String reversed1 = "";
        for (int i = str.length() - 1; i > 0; i--) {
            reversed1 += str.charAt(i);
        }

        // odwracanie stringa na piechotę (wydajne)
        StringBuilder reversed2 = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            reversed2.append(str.charAt(i));
        }
    }

    public void dod(int character) {
        System.out.println(character+character+character);
    }

    String[] tab= new String[0];
}

