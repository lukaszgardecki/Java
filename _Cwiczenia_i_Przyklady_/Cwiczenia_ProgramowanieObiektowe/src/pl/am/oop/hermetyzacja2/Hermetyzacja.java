package pl.am.oop.hermetyzacja2;

public class Hermetyzacja {
    public static void main(String[] args) {
        Punkt p1 = new Punkt();
        Punkt p2 = new Punkt();

        p1.setKartezjusz(5, 5);
        p2.setPolarne(5, 0.2);

        System.out.println(p1);
        System.out.println(p2);

    }
}
