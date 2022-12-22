public class CabrioTest {
    public static void main(String[] args) {
        Cabrio car = new Cabrio("Fiat", "126P");

        car.displayStatus();
        car.go();
        car.openRoof();
        car.stop();
        car.openRoof();
        car.displayStatus();
        car.go();
        car.displayStatus();
    }
}
