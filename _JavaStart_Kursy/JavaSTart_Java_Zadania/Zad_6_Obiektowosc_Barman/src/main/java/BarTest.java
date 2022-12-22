public class BarTest {

    /**
     * Zdefiniuj klasę Barman, która posiada metodę createDrink przyjmującą jako argumenty nazwy oraz ilość 3 składników potrzebnych do przygotowania drinka. W wyniku metoda powinna zwracać obiekt typu Drink z informacjami o składnikach danego drinka. Każdy składnik w klasie Drink powinien być reprezentowany przez klasę Ingredient, która przechowuje nazwę oraz ilość danego składnika.
     *
     * Klasa Barman powinna także posiadać metodę printDrink, która przyjmuje jako parametr obiekt typu Drink i wyświetla o nim informacje postaci:
     *
     * Składniki drinka to AAA, BBB, CCC w proporcjach aaa, bbb, ccc, jego pojemność to zzz
     *
     * gdzie AAA, aaa, itp. reprezentują przekazane do metody argumenty.
     *
     * Dla danych typu:
     *
     * Sok ananasowy, 100, Likier Malibu, 50, Mleko kokosowe, 100
     *
     * Oczekiwany wynik to:
     *
     * Składniki drinka to: Sok ananasowy, Likier malibu, Mleko kokosowe w proporcjach 0.40, 0.20, 0.40.Jego pojemność to 250ml
     *
     * Zagadnienia przydatne do rozwiązania: definiowanie klas, metod i obiektów.
     */

    public static void main(String[] args) {
        Barman barman = new Barman();

        Drink drink1 = barman.createDrink(
                "Sok ananasowy", 100,
                "Likier Malibu", 50,
                "Mleko kokosowe", 100
        );

        barman.printDrink(drink1);
    }
}
