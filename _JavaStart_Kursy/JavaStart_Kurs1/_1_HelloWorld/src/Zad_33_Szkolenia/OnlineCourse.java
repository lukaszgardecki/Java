package Zad_33_Szkolenia;

class OnlineCourse extends Course {
    private int minutes;
    private int timeNeeded;

    public OnlineCourse(String id, double price, String name, String description, int minutes, int timeNeeded) {
        super(id, price, name, description);
        this.minutes = minutes;
        this.timeNeeded = timeNeeded;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", minutes=" + minutes +
                ", timeNeeded=" + timeNeeded;
    }
}
