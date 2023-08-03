package enums;

public class Enums_Main {
    public static void main(String[] args) {

        Planet myPlanet = Planet.JUPITER;

        canILiveHere(myPlanet);
    }
    static void canILiveHere(Planet myPlanet) {
        switch (myPlanet) {
            case MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO ->
                System.out.println("You can't live here!");
            case EARTH -> System.out.println("You can live here!");
        }
        System.out.printf("This is planet #%d\n", myPlanet.number);
    }

}

enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);

    int number;

    Planet(int number) {
        this.number = number;
    }
}
