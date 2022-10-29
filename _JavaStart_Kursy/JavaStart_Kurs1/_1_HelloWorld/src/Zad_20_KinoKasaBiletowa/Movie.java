package Zad_20_KinoKasaBiletowa;

class Movie {
    private String title;
    private String type;
    private int time;
    private int ageRequired;

    public Movie(String title, String type, int time, int ageRequired) {
        this.title = title;
        this.type = type;
        this.time = time;
        this.ageRequired = ageRequired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAgeRequired() {
        return ageRequired;
    }

    public void setAgeRequired(int ageRequired) {
        this.ageRequired = ageRequired;
    }
}
