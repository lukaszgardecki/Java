public class HouseController {
    private House house;

    public HouseController(House house) {
        this.house = house;
    }

    public void controlLoop() {
        while (!house.areAllRoomsCool()) {
            System.out.println(house);
            house.coolRooms();
            sleepOneSecond();
        }
        System.out.println("Wszystkie pomieszczenia schłodzone do docelowej temperatury.");
    }

    private void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
