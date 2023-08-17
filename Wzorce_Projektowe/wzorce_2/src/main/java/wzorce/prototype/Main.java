package wzorce.prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle v1 = new VehicleRegistry().getVehicle("TWO");
        Vehicle v2 = new VehicleRegistry().getVehicle("FOUR");
    }
}
