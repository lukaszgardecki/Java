public class Room {
    private String name;
    private double lengthInM;
    private double widthInM;
    private double heightInM;
    private double temperature;
    private double targetTemperature;
    private AirConditioner airConditioner;


    public Room(String name, double lengthInM,
                double widthInM, double heightInM,
                double temperature, double targetTemperature,
                AirConditioner airConditioner) {
        this.name = name;
        this.lengthInM = lengthInM;
        this.widthInM = widthInM;
        this.heightInM = heightInM;
        this.temperature = temperature;
        this.targetTemperature = targetTemperature;
        this.airConditioner = airConditioner;
    }

    public double getVolume() {
        return lengthInM * widthInM * heightInM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLengthInM() {
        return lengthInM;
    }

    public void setLengthInM(int lengthInM) {
        this.lengthInM = lengthInM;
    }

    public double getWidthInM() {
        return widthInM;
    }

    public void setWidthInM(int widthInM) {
        this.widthInM = widthInM;
    }

    public double getHeightInM() {
        return heightInM;
    }

    public void setHeightInM(int heightInM) {
        this.heightInM = heightInM;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void cool() {
        if (temperature > targetTemperature) {
            temperature = airConditioner.lowerTemperature(temperature, getVolume());
        }
    }

    @Override
    public String toString() {
        return String.format("- %s - temperatura: %.2f°C (%.1f°C), klimatyzator: %s, kubatura: %.2fm3%n",
                name, temperature, targetTemperature, airConditioner, getVolume());
    }
}
