package pl.am.podstawy.lekcja12;

public class Silnia {

    public static long silnia(long n){
        if(n==0) return 1;
        return n * silnia(n-1);

    }

    public static void main(String[] args) {
        System.out.println(silnia(4));
    }
}
