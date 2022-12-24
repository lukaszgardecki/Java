import java.util.*;


/**
 * Poniżej znajduje się fragment aplikacji, w którym przechowywane są informacje o kilku filmach.
 * Dostępna jest w nim tylko jedna opcja sortowania, która wynika z tego jak zaimplementowana jest
 * metoda compareTo w klasie Movie. Sortuje ona filmy po tytule alfabetycznie (prawie, bo nie do końca poradzi
 * sobie z polskimi znakami).
 *
 * Przerób program w taki sposób, aby była możliwość sortowania po nazwie, ocenie (malejąco) lub roku
 * wydania (od najnowszych). Program napisz w taki sposób, aby w przyszłości dodawanie kolejnych algorytmów
 * sortowania nie wymagało żadnych zmian w klasie, w której znajduje się metoda main. W klasie main uzupełnij
 * miejsca oznaczone komentarzem TODO, oprócz tego możesz w niej definiować dodatkowe metody, a także osobne
 * klasy/interfejsy/enumy w osobnych plikach.
 */
public class MovieDatabase {
    private static List<Movie> moviesList;

    public static void main(String[] args) {
        moviesList = createMoviesList();
        Comparator<Movie> sortAlgorithm = getSortAlgorithm();
        moviesList(sortAlgorithm);
        print(moviesList);
    }

    private static void moviesList(Comparator<Movie> sortAlgorithm) {
        moviesList.sort(sortAlgorithm);
    }

    private static List<Movie> createMoviesList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Jumanji", "Johnston Joe", 1995, 6.8));
        movies.add(new Movie("The Shawshank Redemption", "Johnston Joe", 1994, 8.75));
        movies.add(new Movie("The Green Mile", "Darabont Frank", 1999, 8.61));
        movies.add(new Movie("Spider Man", "Raimi Sam", 2002, 6.7));
        movies.add(new Movie("Transformers", "Bay Michael", 2007, 7.3));
        movies.add(new Movie("Alien", "Scott Ridley", 1979, 7.8));
        movies.add(new Movie("Home Alone", "Columbus Chris", 1979, 7.1));
        return movies;
    }

    private static Comparator<Movie> getSortAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        Comparator<Movie> comparator;
        do {
            displayMenu();
            String option = scanner.nextLine();
            comparator = getComparator(option);
            if (comparator == null) {
                System.err.println("Wpisz poprawne kryterium. Spróbuj jeszcze raz!");
            }
        } while (comparator == null);
        return comparator;
    }

    private static void displayMenu() {
        System.out.println("Wybierz kryterium sortowania:");
        Arrays.stream(SortCriterion.values()).forEach(System.out::println);
    }

    private static Comparator<Movie> getComparator(String option) {
        for (SortCriterion value : SortCriterion.values()) {
            if (option.equalsIgnoreCase(value.name())) {
                return value.getComparator();
            }
        }
        return null;
    }

    private static void print(List<Movie> movies) {
        System.out.println("Lista filmów:");
        movies.forEach(System.out::println);
    }

}