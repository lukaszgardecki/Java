package pl.am.oop.rzutowanie;

public class TypyZlozone {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Prostokat(2,3);
        Object object3 = new Kwadrat(6);

        Trojkat trojkat = new Trojkat();

        Object object4 = trojkat;

       // Kwadrat kwadrat3 = (Kwadrat) object4;

        Prostokat prostokat1 = (Prostokat) object2;

        Prostokat prostokat2 = new Kwadrat(4);

        if (prostokat2 instanceof Kwadrat) {
            Kwadrat kwadrat1 = (Kwadrat) prostokat2;
            System.out.println(kwadrat1);
        }


        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);

        System.out.println(prostokat1);

    }
}
