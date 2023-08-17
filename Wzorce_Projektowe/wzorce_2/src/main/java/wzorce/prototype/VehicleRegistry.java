package wzorce.prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private static Map<String, Vehicle> mapVehicles = new HashMap<>();

    static {
        mapVehicles.put("TWO", new TwoWheelerVehicle("120", "royal", 1000, true));
        mapVehicles.put("FOUR", new FourWheelerVehicle("120", "bmw", 1231, true, false));
    }

    public Vehicle getVehicle(String vehicle) throws CloneNotSupportedException {
        return mapVehicles.get(vehicle).clone();
    }
}
