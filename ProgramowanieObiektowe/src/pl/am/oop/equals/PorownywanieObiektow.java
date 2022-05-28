package pl.am.oop.equals;

public class PorownywanieObiektow {
    public static void main(String[] args) {
        Prostokat prostokat1 = new Prostokat(2, 3);
        Prostokat prostokat2 = new Prostokat(2, 3);

        Kwadrat kwadrat1 = new Kwadrat(6);
        Kwadrat kwadrat2 = new Kwadrat(6);

        Prostokat prostokat3 = prostokat1;

        Trojkat trojkat = new Trojkat();

        System.out.println(prostokat1 == prostokat2);
        System.out.println(prostokat1 == prostokat3);
        System.out.println(prostokat1.equals(trojkat));
        System.out.println(kwadrat1.equals(kwadrat2));

    }
}
