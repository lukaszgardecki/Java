package pl.mojastrona.recipes;

import java.util.Scanner;
import java.util.function.Function;


public class CookBookApp {
    private static final RecipeDao DAO = new RecipeDao();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> create();
                case "2" -> read();
                case "3" -> update();
                case "4" -> delete();
                case "5" -> exit();
                default -> System.err.println("Nieznana operacja. Spróbuj jeszcze raz.");
            }
        }
    }

    private static void exit() {
        System.out.println("Zamykam aplikację.");
        DAO.close();
        System.exit(0);
    }

    private static void displayMenu() {
        System.out.println("""
                Wybierz opcję:
                    [1] - stwórz nowy przepis
                    [2] - wyszukaj przepis
                    [3] - aktualizuj przepis
                    [4] - usuń przepis
                    [5] - wyjdź
                """);
    }

    private static void create() {
        System.out.println("Podaj tytuł przepisu:");
        String title = scanner.nextLine();
        System.out.println("Podaj opis:");
        String description = scanner.nextLine();
        System.out.println("Podaj składniki:");
        String ingredients = scanner.nextLine();
        System.out.println("Podaj czas przygotowania (liczba całkowita):");
        int preptime = scanner.nextInt();
        scanner.nextLine();

        Recipe recipe = new Recipe(title, description, ingredients, preptime);

//        Recipe recipe = new Recipe("Kurczak z frytkami", """
//                Ziemniaki pokrój w słupki o grubości ok 1cm, możesz je zamarynować w oleju z ziołami i papryką,
//                Pierś z kurczaka oczyść z błonek, pokrój w plastry i delikatnie rozbij. Zamarynuj w ulubionych przyprawach.
//                Rozgrzej piekarnik do temperatury 180 stopni, najpierw umieść na blaszce frytki, a po 20 minutach dorzuć
//                kurczaka i piecz jeszcze 20 minut (łącznie 40 minut). Podawaj z ulubionym sosem lub keczupem.
//                """, "ziemniaki, pierś z kurczaka, zioła prowansalskie, oliwa", 30);
        System.out.println("Zapisuję przepis...");
        DAO.save(recipe);
        System.out.println("Przepis zapisany, jego id to: " + recipe.getId());
    }

    private static void read() {
        System.out.println("Podaj tytuł przpisu, który ma zostać wyszukany:");
        String title = scanner.nextLine();

        DAO.findByTitle(title).ifPresentOrElse(
                recipe -> System.out.println("Szukany przepis:\n" + recipe),
                () -> System.out.println("Brak przepisu o takiej nazwie.")
        );
    }

    private static void update() {
        System.out.println("Podaj tytuł przepisu, który ma zostać edytowany:");
        String title = scanner.nextLine();

        DAO.findByTitle(title).ifPresentOrElse(CookBookApp::chooseEditOption,
                () -> System.out.println("Brak przepisu o takiej nazwie.")
        );
    }

    private static void chooseEditOption(Recipe recipe) {
        displayEditMenu();
        String choice = scanner.nextLine();


        Function<Recipe, Recipe> updateRecipePrepTime = rec -> {
            switch (choice) {
                case "1" -> {
                    System.out.println("Podaj nowy tytuł:");
                    String newTitle = scanner.nextLine();
                    rec.setTitle(newTitle);
                }
                case "2" -> {
                    System.out.println("Podaj nowy opis:");
                    String description = scanner.nextLine();
                    rec.setDescription(description);
                }
                case "3" -> {
                    System.out.println("Podaj nowe składniki:");
                    String ingredients = scanner.nextLine();
                    rec.setIngredients(ingredients);
                }
                case "4" -> {
                    System.out.println("Podaj nowy czas przygotowania:");
                    int preptime = scanner.nextInt();
                    rec.setPrepTime(preptime);
                }
            }
            return rec;
        };
        DAO.findByTitle(recipe.getTitle())
                .map(updateRecipePrepTime)
                .map(DAO::update)
                .filter(b -> b)
                .ifPresent(updated -> System.out.println("Przepis został zaktualizowany."));


    }

    private static void displayEditMenu() {
        System.out.println("""
                Wybierz element, który chcesz edytować:
                [1] - tytuł
                [2] - opis
                [3] - składniki
                [4] - czas przygotowania
                """);
    }

    private static void delete() {
        System.out.println("Podaj tytuł przepisu, który ma zostać usunięty:");
        String title = scanner.nextLine();
        DAO.findByTitle(title)
                .map(Recipe::getId)
                .map(DAO::delete)
                .ifPresentOrElse(removed -> System.out.println("Przepis został usunięty"),
                        () -> System.out.println("W bazie nie ma przepisu do usunięcia"));
    }
}
