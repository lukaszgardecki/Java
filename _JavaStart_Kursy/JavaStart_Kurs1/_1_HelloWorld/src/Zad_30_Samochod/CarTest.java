package Zad_30_Samochod;

class CarTest {
    public static void main(String[] args) {
        Car car = new Car(2, true, false, false);
        System.out.println(car.start());
        System.out.println(car.status());
    }

}
