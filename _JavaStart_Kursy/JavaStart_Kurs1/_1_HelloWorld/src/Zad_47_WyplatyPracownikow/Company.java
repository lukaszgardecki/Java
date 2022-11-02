package Zad_47_WyplatyPracownikow;

class Company {
    public static final String CURRENCY = "z³";
    private Employee[] employees;
    private int addedEmployees;
    private String name;

    Company(String name, int numOfEmployees) {
        employees = new Employee[numOfEmployees];
        this.name = name;
    }

    double getMonthSalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getMonthSalary();
            }
        }
        return totalSalaries;
    }

    double getYearSalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getYearSalary();
            }
        }
        return totalSalaries;
    }

    private String printAllEmployees() {
        String s = "";
        for (Employee employee : employees) {
            if (employee != null) {
                s += employee.toString();
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", name, printAllEmployees()) +
                String.format("Suma miesiêcznych wynagrodzeñ: %.1f%s%n", getMonthSalaries(), CURRENCY) +
                String.format("Suma rocznych wynagrodzeñ: %.1f%s%n", getYearSalaries(), CURRENCY);
    }

    void add(Employee employee) {
        employees[addedEmployees] = employee;
        addedEmployees++;
    }
}
