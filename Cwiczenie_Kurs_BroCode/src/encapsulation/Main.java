package encapsulation;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Opel", "Corsa", 2017);
        Car car2 = new Car("Fiat", "nie wiem", 2049);

        car2= car1;

        System.out.println(car1.toString());
        System.out.println(car2.toString());


    }
}
