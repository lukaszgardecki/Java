import java.util.Comparator;

public enum SortCriterion {
    TITLE("Title", Comparator.comparing(Movie::getTitle)),
    RATING("Rating", Comparator.comparingDouble(Movie::getRating).reversed()),
    YEAR("Year", Comparator.comparingInt(Movie::getYear).reversed());

    private final String name;
    private final Comparator<Movie> comparator;

    SortCriterion(String name, Comparator<Movie> comparator) {
        this.name = name;
        this.comparator = comparator;
    }

    public Comparator<Movie> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        return String.format(">%s", name);
    }
}
