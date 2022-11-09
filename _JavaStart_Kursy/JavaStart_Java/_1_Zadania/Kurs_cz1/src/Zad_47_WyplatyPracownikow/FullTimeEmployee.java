package Zad_47_WyplatyPracownikow;

class FullTimeEmployee extends Employee{
    private final double bonusInPercent = 5;
    private double salary;

    public FullTimeEmployee(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    double getMonthSalary() {
        return salary;
    }

    @Override
    double getYearSalary() {
        return (1 + bonusInPercent/100) * (12 * salary);
    }
}
