package zad2._29;

public class Main {
    public static void main(String[] args) {
        int liczba = 1;

        //sposób 1:
//        while (liczba <= 20) {
//            if (liczba % 2 == 0) {
//                liczba++;
//                 continue;
//            } else
//                System.out.println(liczba + " ");
//            liczba++;
//        }

        //sposób 2:
        while (liczba <= 20) {
            if (liczba % 2 != 0) {
                System.out.println(liczba);
            }
            liczba++;

        }







    }
}
