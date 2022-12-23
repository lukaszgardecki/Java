public class ProAirConditioner implements AirConditioner{
    private static final double COOL_TEMPERATURE = 2;


    @Override
    public double lowerTemperature(double temperature, double volume) {
        return temperature - (COOL_TEMPERATURE / volume);
    }

    @Override
    public String toString() {
        return "Pro";
    }
}
