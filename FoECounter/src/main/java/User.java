import java.util.Objects;

public class User implements Comparable<User> {
    private long id;
    private String name;
    private int negotiations;
    private int battles;
    private int totalScore;
    private double percentage;
    private int totalScore3OrLessCamps;
    private int totalScore4OrMoreCamps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNegotiations() {
        return negotiations;
    }

    public void setNegotiations(int negotiations) {
        this.negotiations = negotiations;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getTotalScore3OrLessCamps() {
        return totalScore3OrLessCamps;
    }

    public void setTotalScore3OrLessCamps(int totalScore3OrLessCamps) {
        this.totalScore3OrLessCamps = totalScore3OrLessCamps;
    }

    public int getTotalScore4OrMoreCamps() {
        return totalScore4OrMoreCamps;
    }

    public void setTotalScore4OrMoreCamps(int totalScore4OrMoreCamps) {
        this.totalScore4OrMoreCamps = totalScore4OrMoreCamps;
    }

    public double getPercentageTotalScore3OrLessCamps() {
        return (totalScore3OrLessCamps * 100.0) / (totalScore3OrLessCamps + totalScore4OrMoreCamps);
    }
    public double getPercentageTotalScore4OrMoreCamps() {
        return (totalScore4OrMoreCamps * 100.0) / (totalScore3OrLessCamps + totalScore4OrMoreCamps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && negotiations == user.negotiations && battles == user.battles && totalScore == user.totalScore && Double.compare(user.percentage, percentage) == 0 && totalScore3OrLessCamps == user.totalScore3OrLessCamps && totalScore4OrMoreCamps == user.totalScore4OrMoreCamps && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, negotiations, battles, totalScore, percentage, totalScore3OrLessCamps, totalScore4OrMoreCamps);
    }



    @Override
    public String toString() {
        return String.format("- %s: W3: %s (%.2f%%), W4: %s (%.2f%%)",
                name,
                totalScore3OrLessCamps,
                getPercentageTotalScore3OrLessCamps(),
                totalScore4OrMoreCamps,
                getPercentageTotalScore4OrMoreCamps()
        );
    }

    public String toSectorStatsString() {
        return String.format("- %s - N:%s, W:%s, S:%s, U:%.2f%%",
                name, negotiations, battles, totalScore, percentage);
    }

    @Override
    public int compareTo(User o) {
        if (this.getPercentageTotalScore3OrLessCamps() == o.getPercentageTotalScore3OrLessCamps()) {
            if (this.getPercentageTotalScore4OrMoreCamps() == o.getPercentageTotalScore4OrMoreCamps()) {
                return Integer.compare(o.getTotalScore4OrMoreCamps(), this.getTotalScore4OrMoreCamps());
            } else if (this.getPercentageTotalScore4OrMoreCamps() > o.getPercentageTotalScore4OrMoreCamps()) {
                return  -1;
            } else return 1;
        } else if (this.getPercentageTotalScore3OrLessCamps() > o.getPercentageTotalScore3OrLessCamps()) {
            return 1;
        } else {
            return -1;
        }
    }
}
