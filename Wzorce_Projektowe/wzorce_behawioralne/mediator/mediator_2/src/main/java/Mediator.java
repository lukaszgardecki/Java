public class Mediator {
    private final Plane plane;
    private final PlanesInFlight planesInFlight;
    private final PlanesOnGround planesOnGround;
    private final Runway runway;

    public Mediator() {
        plane = new Plane(123);
        runway = new Runway();
        planesInFlight = new PlanesInFlight();
        planesOnGround = new PlanesOnGround();
        planesOnGround.addPlane(plane);
    }

    public void takeOff() {
        if(!plane.getIsInTheAir() && runway.getIsAvailable()) {
            System.out.println("Plane " + plane.getId() + " is taking off...");
            planesOnGround.removePlane(plane);
            planesInFlight.addPlane(plane);
            plane.setIsInTheAir(true);
            runway.setIsAvailable(false);
        }
    }
}
