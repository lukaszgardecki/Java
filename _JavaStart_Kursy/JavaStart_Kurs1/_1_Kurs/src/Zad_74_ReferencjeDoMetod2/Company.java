package Zad_74_ReferencjeDoMetod2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Company {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        //10% podwy¿ki dla pracowników zatrudnionych na pe³en etat
        addBonusToFullTimeEmployees(employees);

        //liczba pracowników etatowych
        double fullTimeEmployeesNumber = countEmployeesByEmployment(employees, Employment.FULL_TIME);

        System.out.println("Liczba pracowników zatrudnionych na pe³en etat: " + fullTimeEmployeesNumber);
        System.out.println("Oto oni:");
        employees.stream()
                 .filter(Company::isFullTimeEmployee)
                 .forEach(System.out::println);

        employeeWithLongestName(employees)
                .ifPresent(Company::displayEmployee);
    }


    private static void displayEmployee(String s) {
        System.out.println("Pracownik o najd³u¿szym imieniu i nazwisku to " + s);
    }

    private static Optional<String> employeeWithLongestName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getFullName)
                .max(Comparator.comparingInt(String::length));
    }

    private static long countEmployeesByEmployment(List<Employee> employees, Employment employment) {
        return employees.stream()
                .filter(employment::checkEmployeeEmployment)
                .count();
    }

    private static void addBonusToFullTimeEmployees(List<Employee> employees) {
        employees.stream()
                .filter(Company::isFullTimeEmployee)
                .forEach(Employee::set10PercentBonus);
    }

    private static boolean isFullTimeEmployee(Employee employee) {
        return employee.getEmployment() == Employment.FULL_TIME;
    }

    private static List<Employee> createEmployees() {
        return List.of(
                new Employee("Jan", "Kowalski", 4000, Employment.FULL_TIME),
                new Employee("Marta", "Baczewska", 3900, Employment.FULL_TIME),
                new Employee("Karol", "Piotrowicz", 5800, Employment.CONTRACT),
                new Employee("Anna", "Lubicz", 6000, Employment.PART_TIME),
                new Employee("Wojciech", "Koz³owski", 3500, Employment.PART_TIME),
                new Employee("Pawe³", "Kowalski", 8000, Employment.FULL_TIME),
                new Employee("Adam", "Marchwicki", 300, Employment.CONTRACT)
        );
    }
}
