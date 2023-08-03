package zad2._9;

    //Operator inkrementacji
public class Main {
    public static void main(String[] args) {
        int x = 1, y;
        System.out.println(++x);        // =2
        System.out.println(x++);        // =2
        System.out.println(x);          // =3
        y = x++;                        // =3
        System.out.println(y);          // =3
        y = ++x;                        // =5
        System.out.println(++y);        // =6
    }
}
