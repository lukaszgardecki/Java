package rozdzial_4;

public class zad2 {

/*
* Napisz kod, który wyświetla dwójkową reprezentację liczby rzeczywistej z przedziału od 0
* do 1 (na przykład 0,72) przekazanej jako liczba zmiennoprzecinkowa o podwójnej precyzji.
* Jeśli danej wartości nie można precyzyjnie przedstawić za pomocą 32 znakó, kod ma
* wyświetlać komunikat "Błąd".
*/
    public static void main(String[] args) {
        System.out.println(printBinary(0.79));
    }


    static String printBinary(double num) {
        if (num >= 1 || num <= 0) return "Błąd";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            //ustawienie limitu długości na 32 znaki
            if (binary.length() >= 32) return "Błąd";
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}
