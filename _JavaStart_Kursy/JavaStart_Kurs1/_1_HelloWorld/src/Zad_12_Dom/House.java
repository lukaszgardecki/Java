package Zad_12_Dom;

public class House {
    double water;
    double petroleum;

    public House(double water, double petroleum) {
        this.water = water;
        this.petroleum = petroleum;
    }

    void takeShower() {
        water -= 48;
        System.out.println("Bierzemy prysznic.");
    }

    void takeBath() {
        water -= 86;
        System.out.println("Bierzemy k¹piel.");
    }

    void makeDinner() {
        water -= 4;
        petroleum -= 0.1;
        System.out.println("Robimy kolacjê.");
    }

    void boilWater() {
        water -= 0.5;
        petroleum -= 0.05;
        System.out.println("Gotujemy wodê.");
    }

    void watchTV(int hours) {
        petroleum -= (0.06 * hours);
        System.out.println("Ogl¹damy TV przez " + hours + " godziny.");
    }

    @Override
    public String toString() {
        return "Iloœæ wody:" + water + ", ropa:" + petroleum;
    }


    public static void main(String[] args) {
        House house = new House(2456, 1000);

        System.out.println(house);
        house.takeBath();
        System.out.println(house);
        house.takeShower();
        System.out.println(house);
        house.boilWater();
        System.out.println(house);
        house.watchTV(5);
        System.out.println(house);
        house.makeDinner();
        System.out.println(house);
    }
}
