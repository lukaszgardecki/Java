import java.util.HashMap;

public class VehicleFactory {
    HashMap<Integer, Vehicle> vehicles = new HashMap<>();

    public Vehicle getVehicle(int type) {
        if (vehicles.containsKey(type)) {
            return vehicles.get(type);
        } else {
            Vehicle vehicle;
            if (type == 0) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }
            vehicles.put(type, vehicle);
            return vehicle;
        }
    }
}
