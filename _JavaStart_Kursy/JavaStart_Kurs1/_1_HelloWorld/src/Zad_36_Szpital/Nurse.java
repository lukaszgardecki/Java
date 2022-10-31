package Zad_36_Szpital;

class Nurse extends Person {
    private double overtime;

    public Nurse(String firstName, String lastName, double salary, double overtime) {
        super(firstName, lastName, salary);
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    @Override
    String getInfo() {
        return super.getInfo() + String.format(", Nadgodziny: %.1f", overtime);
    }
}
