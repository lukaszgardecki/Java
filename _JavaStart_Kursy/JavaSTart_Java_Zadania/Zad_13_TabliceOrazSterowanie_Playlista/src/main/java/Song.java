public class Song {
    private String name;
    private int timeInSec;

    public Song(String name, int timeInSec) {
        this.name = name;
        this.timeInSec = timeInSec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeInSec() {
        return timeInSec;
    }

    public void setTimeInSec(int timeInSec) {
        this.timeInSec = timeInSec;
    }
}
