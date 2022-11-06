package Zad_47_WyplatyPracownikow;

class PartTimeEmployee extends Employee{
    private double hoursPerMonth;
    private double hourlyRate;

    public PartTimeEmployee(String firstName, String lastName, double hoursPerMonth, double hourlyRate) {
        super(firstName, lastName);
        this.hoursPerMonth = hoursPerMonth;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double getMonthSalary() {
        return hoursPerMonth * hourlyRate;
    }

    @Override
    double getYearSalary() {
        return 12 * getMonthSalary();
    }
}
