public class CabrioTest {

    /**
     * Zdefiniuj klasę Cabrio reprezentującą samochód z otwieranym dachem.
     * Samochód powinien przechowywać informację o nazwie, marce, ale także to, czy aktualnie się porusza oraz, czy dach jest otwarty.
     * Ograniczeniem jest to, że nie powinno być możliwe otwarcie ani zamknięcie dachu w sytuacji, gdy samochód jest w ruchu.
     * Jeśli samochód jest w ruchu i ktoś spróbuje otworzyć lub złożyć dach powinien zostać wyświetlony
     * komunikat o błędzie a dach powinien zostać w swojej aktualnej pozycji.
     *
     * W osobnej klasie stwórz obiekt reprezentujący samochód i przetestuj otwieranie dachu w sytuacji,
     * gdy samochód jest w ruchu oraz w spoczynku.
     *
     * Zagadnienia przydatne do rozwiązania: definiowanie klas i obiektów, definiowanie metod, instrukcje sterujące
     */

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
