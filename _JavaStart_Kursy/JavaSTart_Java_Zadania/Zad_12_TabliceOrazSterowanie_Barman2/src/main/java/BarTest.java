import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BarTest {

    /**
     * W jednym z poprzednich zadań należało stworzyć klasę Drink, która reprezentowała drinka złożonego z 3 składników.
     * Tym razem napisz to samo zadanie, ale w taki sposób, aby drink mógł zawierać dowolną ilość składników,
     * a same informacje o składnikach powinny być wczytywane od użytkownika.
     *
     * Pełna treść zadania:
     * Zdefiniuj klasę Barman, która posiada metodę createDrink która tworzy drinka z dowolną ilością
     * składników podanych przez użytkownika. W wyniku metoda powinna zwracać obiekt typu Drink z informacjami
     * o składnikach danego drinka. Każdy składnik w klasie Drink powinien być reprezentowany przez klasę Ingredient,
     * która przechowuje nazwę oraz ilość danego składnika. Dane wczytaj od użytkownika korzystającego z aplikacji.
     *
     * Klasa Barman powinna także posiadać metodę printDrink, która przyjmuje jako parametr obiekt typu Drink i wyświetla o nim informacje.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilość składników:");
        int numOfIngredients = scanner.nextInt();
        scanner.nextLine();

        List<Ingredient> ingredients = new ArrayList<>(numOfIngredients);

        for (int i = 0; i < numOfIngredients; i++) {
            System.out.println("Podaj nazwę składnika:");
            String nameOfIngredient = scanner.nextLine();
            System.out.println("Podaj ilość składnika:");
            int amountOfIngredient = scanner.nextInt();
            scanner.nextLine();
            ingredients.add(new Ingredient(nameOfIngredient, amountOfIngredient));
        }
        Drink drink = Barman.createDrink(ingredients);
        Barman.printDrink(drink);
    }
}
