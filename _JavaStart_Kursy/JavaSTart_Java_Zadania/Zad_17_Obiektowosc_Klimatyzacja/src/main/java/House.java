import java.util.Random;

public class House {
    private Room[] rooms;

    public House(int numOfRooms) {
        rooms = new Room[numOfRooms];
        generateRooms();
    }

    private void generateRooms() {
        Random random = new Random();

        for (int i = 0; i < rooms.length; i++) {
            String name = generateName();
            double currentTemperature = 20 + random.nextDouble(15); //od 20 do 35 stopni
            double targetTemperature = currentTemperature - random.nextDouble(10);
            double length = 3.2 + random.nextDouble(5);
            double width = 2.2 + random.nextDouble(4);
            double height = 2.4 + random.nextDouble(0.2);
            AirConditioner airConditioner = getRandomAirConditioner();
            rooms[i] = new Room(name, length, width, height, currentTemperature, targetTemperature, airConditioner);
        }
    }

    private String generateName() {
        Random random = new Random();
        String[] names = {"Kuchnia", "Łazienka", "Przedpokój", "WC", "Salon", "Sypialnia", "Garderoba", "Pralnia"};
        return names[random.nextInt(names.length)];
    }

    private AirConditioner getRandomAirConditioner() {
        Random random = new Random();
        double value = random.nextDouble();
        if (value < 0.5) {
            return new BasicAirConditioner();
        } else {
            return new ProAirConditioner();
        }
    }

    public boolean areAllRoomsCool() {
        for (Room room : rooms) {
            if (room.getTemperature() > room.getTargetTemperature()) {
                return false;
            }
        }
        return true;
    }

    public void coolRooms() {
        for (Room room : rooms) {
            room.cool();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room);
        }
        return sb.toString();
    }
}
