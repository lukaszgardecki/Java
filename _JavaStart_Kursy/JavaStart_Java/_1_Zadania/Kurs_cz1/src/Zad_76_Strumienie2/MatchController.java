package Zad_76_Strumienie2;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MatchController {
    public static void main(String[] args) {
        List<MatchResult> matches = createStream();

        System.out.println(">>> Wszystkie mecze:");
        printAll(matches);

        System.out.println(">>> Wszystkie spotkania Polski:");
        String team = "Polska";
        printAll(team, matches);

        System.out.println();

        System.out.print("Liczba dru¿yn bior¹cych udzia³ w rozgrywkach: " + countUniqueTeamNames(matches));
        System.out.println();

        System.out.println();
        System.out.println("£¹czna liczba goli: " + getNumOfAllGoals(matches));
    }

    private static int getNumOfAllGoals(List<MatchResult> matches) {
        return matches.stream()
                .flatMapToInt(MatchController::getAllGoals)
                .sum();
    }

    private static IntStream getAllGoals(MatchResult m) {
        return IntStream.of(m.getGuestTeamGoals(), m.getHomeTeamGoals());
    }


    private static long countUniqueTeamNames(List<MatchResult> matches) {
        return matches.stream()
                .flatMap(MatchController::getTeamNames)
                .distinct()
                .count();
    }

    private static Stream<String> getTeamNames(MatchResult m) {
        return Stream.of(m.getGuestTeamName(), m.getHomeTeamName());
    }

    private static void printAll(List<MatchResult> matches) {
        matches.stream()
                .sorted(MatchController::sort)
                .forEach(System.out::println);
    }

    private static void printAll(String team, List<MatchResult> matches) {
        matches.stream()
                .filter(m -> m.getHomeTeamName().equals(team) || m.getGuestTeamName().equals(team))
                .forEach(System.out::println);
    }

    private static int sort(MatchResult m1, MatchResult m2) {
        int dif1 = m1.getHomeTeamGoals() - m1.getGuestTeamGoals();
        int dif2 = m2.getHomeTeamGoals() - m2.getGuestTeamGoals();
        return Integer.compare(dif1, dif2);
    }

    private static List<MatchResult> createStream() {
        return List.of(
                new MatchResult("Brazylia", "Francja", 0, 3),
                new MatchResult("Anglia", "Niemcy", 1, 2),
                new MatchResult("Brazylia", "Argentyna", 2, 2),
                new MatchResult("Brazylia", "Niemcy", 3, 3),
                new MatchResult("W³ochy", "Polska", 2, 1),
                new MatchResult("Polska", "Portugalia", 1, 0),
                new MatchResult("Polska", "Irlandia", 2, 0),
                new MatchResult("Anglia", "Francja", 3, 0),
                new MatchResult("Niemcy", "Francja", 3, 6),
                new MatchResult("Hiszpania", "Francja", 2, 5),
                new MatchResult("Anglia", "Polska", 2, 0),
                new MatchResult("Anglia", "S³owacja", 4, 1),
                new MatchResult("Rosja", "Hiszpania", 3, 5),
                new MatchResult("Anglia", "W³ochy", 2, 1),
                new MatchResult("W³ochy", "Francja", 1, 6),
                new MatchResult("Polska", "W³ochy", 2, 1)
        );
    }
}
