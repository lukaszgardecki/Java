package Zad_47_WyplatyPracownikow;

abstract class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    abstract double getMonthSalary();
    abstract double getYearSalary();

    @Override
    public String toString() {
        return String.format("%s %s, wyp³ata miesiêczna: %.1f%5$s, wyp³ata roczna: %.1f%5$s%n",
                firstName, lastName, getMonthSalary(), getYearSalary(), Company.CURRENCY);
    }
}
