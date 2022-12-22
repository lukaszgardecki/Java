public class Cabrio {
    private String brand;
    private String model;
    private boolean isMoving;
    private boolean isRoofOpen;

    public Cabrio(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public void go() {
        this.isMoving = true;
        System.out.println("Ruszam...");
    }

    public void stop() {
        this.isMoving = false;
        System.out.println("...zatrzymuję.");
    }

    public void openRoof() {
        if (!isMoving) {
            this.isRoofOpen = true;
            System.out.println("Otwieram dach...");
        } else {
            System.out.println("Samochód jest w ruchu. Nie można otworzyć dachu. Najpierw zatrzymaj samochód.");
        }
    }

    public void displayStatus() {
        if (isMoving) {
            System.out.print("Samochód jest w ruchu");
        } else {
            System.out.print("Samochód stoi");
        }
        if (isRoofOpen) {
            System.out.print(" i ma otwarty dach.\n");
        } else {
            System.out.print(" i ma zamknięty dach.\n");
        }
    }

    public void closeRoof() {
        if (!isMoving) {
            this.isRoofOpen = false;
        } else {
            System.out.println("Samochód jest w ruchu. Nie można zamknąć dachu. Najpierw zatrzymaj samochód.");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isRoofOpen() {
        return isRoofOpen;
    }

    public void setRoofOpen(boolean roofOpen) {
        isRoofOpen = roofOpen;
    }
}
