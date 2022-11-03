package Zad_59_Comparator2;

import java.util.Objects;

class Property {
    private String city;
    private double price;
    private double area;
    private double priceForArea;

    public Property(String city, double price, double area) {
        this.city = city;
        this.price = price;
        this.area = area;
        this.priceForArea = price / area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPriceForArea() {
        return priceForArea;
    }

    public void setPriceForArea(double priceForArea) {
        this.priceForArea = priceForArea;
    }

    @Override
    public String toString() {
        return String.format("%s, %.1fz³, %.1fmkw, %.2fz³/mkw%n", city, price, area, priceForArea);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.price, price) == 0 && Double.compare(property.area, area) == 0 && Double.compare(property.priceForArea, priceForArea) == 0 && Objects.equals(city, property.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, price, area, priceForArea);
    }
}
