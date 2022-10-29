package Zad_20_KinoKasaBiletowa;

public class CinemaHall {
    private int number;
    private int maxSeats;
    private int freeSeats;

    public CinemaHall(int number, int maxSeats) {
        this.number = number;
        this.maxSeats = maxSeats;
        this.freeSeats = maxSeats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }
}
