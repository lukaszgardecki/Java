package Zad_6;

public class Plant {
    String name;
    String description;
    double waterPerDay;

    public Plant(String name, String description, double waterPerDay) {
        this.name = name;
        this.description = description;
        this.waterPerDay = waterPerDay;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", waterPerDay=" + waterPerDay +
                '}';
    }
}
