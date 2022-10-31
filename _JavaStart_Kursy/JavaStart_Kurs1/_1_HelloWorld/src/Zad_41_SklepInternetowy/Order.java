package Zad_41_SklepInternetowy;

class Order {
    private String fullName;
    private double price;
    private Status status;

    public Order(String fullName, double price, Status status) {
        this.fullName = fullName;
        this.price = price;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2fz³) - %s", fullName, price, status.getDesc());
    }




}
