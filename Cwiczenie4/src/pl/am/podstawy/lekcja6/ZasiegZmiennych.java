package pl.am.podstawy.lekcja6;

public class ZasiegZmiennych {
    public static void main(String[] args) {
        //zmiennej nie mozna używać przed deklaracją
        //a = 1;
        int a;

        {
            int b;
            a = 1;
            {

            }
        }
        //tutaj nie ma już zmiennej b
        //b = 1;
    }
}
