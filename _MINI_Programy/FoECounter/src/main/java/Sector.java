import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sector implements Comparable<Sector> {
    private int camps;
    private List<User> activeUsers = new ArrayList<>();
    private int battles;
    private int negotiations;
    private int totalScore;
    private LocalDateTime date;

    public int getCamps() {
        return camps;
    }

    public void setCamps(int camps) {
        this.camps = camps;
    }

    public List<User> getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(List<User> activeUsers) {
        this.activeUsers = activeUsers;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getNegotiations() {
        return negotiations;
    }

    public void setNegotiations(int negotiations) {
        this.negotiations = negotiations;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = date.format(formatter);
        String activeUsersListStr = activeUsers.stream()
                .sorted((a, b) -> -Double.compare(a.getPercentage(), b.getPercentage()))
                .map(User::toSectorStatsString)
                .collect(Collectors.joining("\n"));

        return String.format("""
                -----------
                Data: %s
                Sektor: obozy=%s, ilość graczy=%s, walki=%s, negocjacje=%s, wynik z pomiaru=%s
                 (N - nego, W - walki, S - suma, U - udział w sektorze)
                %s
                """,
                formatDateTime, camps, activeUsers.size(), battles, negotiations, totalScore,
                activeUsersListStr
        );
    }

    @Override
    public int compareTo(Sector o) {
        return date.compareTo(o.getDate());
    }
}
