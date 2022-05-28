package pl.am.oop.dziedziczenie;

public class Dziedziczenie {
    public static void main(String[] args) {

        Object object = new Object();
        System.out.println(object.toString());
        System.out.println(object);
        System.out.println(object.hashCode());
        System.out.println(object.getClass().getName());
        System.out.println(object.equals(object));

        Prostokat prostokat = new Prostokat(2, 5);
        Kwadrat kwadrat = new Kwadrat(7);



        System.out.println(prostokat);
        System.out.println(kwadrat);

    }
}
