package pl.am.podstawy.lekcja6;

public class PetlaFor {
    public static void main(String[] args) {
        //wypisz liczby od 1 do 1000:
//        for (int i = 1;i <= 1000;i++) {
//            System.out.println(i);
//        }

        //wypisz liczby od 1000 do 1:
//        for (int i = 1000; i >= 1; i--) {
//            System.out.println(i);
//        }
        // wypisz liczby parzyste od 2 do 1000:
//        for (int i = 2;i <= 1000;i+=2) {
//            System.out.println(i);
//        }
        // wypisz kwadraty liczb od 1 do 1000:
        for (int i = 1;i <= 1000;i++) {
            int kwadrat = i * i;
            System.out.println(i + " * " + i + " = " + kwadrat);
        }
    }
}
