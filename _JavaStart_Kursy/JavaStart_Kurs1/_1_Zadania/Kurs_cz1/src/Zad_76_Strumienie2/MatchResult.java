package Zad_76_Strumienie2;

class MatchResult {
    private String homeTeamName;
    private String guestTeamName;
    private int homeTeamGoals;
    private int guestTeamGoals;

    public MatchResult(String homeTeamName, String guestTeamName, int homeTeamGoals, int guestTeamGoals) {
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        this.homeTeamGoals = homeTeamGoals;
        this.guestTeamGoals = guestTeamGoals;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }

    @Override
    public String toString() {
        return String.format("%s - %s(%d:%d)", homeTeamName, guestTeamName, homeTeamGoals, guestTeamGoals);
    }
}
