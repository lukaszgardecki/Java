package Zad_64_Mapy;

import java.util.HashMap;
import java.util.Map;

class Company {
    private Map<Integer, Employee> employees = new HashMap<>();
    private int employeeID = 1;
    private String name;

    public Company(String name) {
        this.name = name;
    }

    void add(Employee employee) {
        employee.setId(employeeID);
        employees.put(employeeID++, employee);
    }

    Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees.values()) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new LackOfEmployeeException("Brak pracownika w bazie.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Firma \"%s\", wydruk pracowników:%n", this.getName()));
        for (Employee employee : employees.values()) {
            sb.append(employee);
        }
        if (employees.size() == 0) sb.append("Brak pracowników.");
        return sb.toString();
    }
}
