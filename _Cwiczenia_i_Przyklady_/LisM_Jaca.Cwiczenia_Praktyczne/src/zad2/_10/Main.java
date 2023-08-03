package zad2._10;

    //Operator dekrementacji
public class Main {
    public static void main(String[] args) {
        int x = 1, y;
        System.out.println(--x);        // =0 (x=0)
        System.out.println(x--);        // =0 (x=-1)
        System.out.println(x);          // =-1 (x=-1)
        y = x--;                        // =-1 (y=-1) (x=-2)
        System.out.println(y);          // =-1 (y-1)
        y = --x;                        // =-3 (x=-3)
        System.out.println(--y);        // =-4 (y=-4)
    }
}
