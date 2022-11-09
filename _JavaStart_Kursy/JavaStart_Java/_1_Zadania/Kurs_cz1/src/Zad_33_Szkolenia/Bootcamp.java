package Zad_33_Szkolenia;

class Bootcamp extends Course {
    private String trainerFirstName;
    private String trainerLastName;
    private int hours;

    public Bootcamp(String id, double price, String name, String description, String trainerFirstName, String trainerLastName, int hours) {
        super(id, price, name, description);
        this.trainerFirstName = trainerFirstName;
        this.trainerLastName = trainerLastName;
        this.hours = hours;
    }

    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public String getTrainerLastName() {
        return trainerLastName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", trainerFirstName='" + trainerFirstName + '\'' +
                ", trainerLastName='" + trainerLastName + '\'' +
                ", hours=" + hours;
    }
}
