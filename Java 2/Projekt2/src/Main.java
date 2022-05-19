
//Jest to klasa Main, a to jest przykładowy komentarz

public class Main
{
//    byte b = 127; //wartości od -128 do 127
//    short s = 32767; // -32768 do 32767
//    int i = -2147483648; // -2147483648 do 2147483647
//    long l = 9223372036854775807l; //musi być zakończona literką "L"  wartości od -9223372036854775808 do 9223372036854775807
//    float f = 3.444444f; //na końcu literka "F"
//    double d = 3.777654545656345645; //nie musi mieć literki D na końću
//    char c = 'a'; //większość liter występujących na świecie
//    String string = "Toj jest jakiś tekst";


    public static void main (String[] args)
    {
        byte b = 127;
        b++;
        b++;
        System.out.println(b);


        int wynik1, wynik2 = 7, wynik3, wynik4;
        int l1 = 56;
        int l2 = 16;
        wynik1 = l1 + l2;
        wynik2 = l1 - l2;
        wynik3 = l1 * l2;
        wynik4 = l1 / l2;
        int wynik5 = l1 % l2;
        System.out.println("Wynik = " + wynik1);
        System.out.println("Wynik = " + wynik2);
        System.out.println("Wynik = " + wynik3);
        System.out.println("Wynik = " + wynik4);
        System.out.println("Wynik = " + wynik5);
        wynik5++; //+!
        wynik5++; //+!
        wynik5++; //+!
        System.out.println("Wynik = " + wynik5);
        wynik1--; //-1
        System.out.println("Wynik = " + wynik1);
    }
}
