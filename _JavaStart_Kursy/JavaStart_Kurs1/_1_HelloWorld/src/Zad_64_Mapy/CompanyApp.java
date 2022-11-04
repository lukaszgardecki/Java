package Zad_64_Mapy;

import java.util.InputMismatchException;
import java.util.Scanner;

class CompanyApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company;
    public static void main(String[] args) {
        company = new Company("Szlachta nie pracuje");
        System.out.println("Witamy w firmie " + company.getName());
        startMenu();
    }

    private static void startMenu() {
        while(true) {
            printMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> exit();
                case "1" -> addNewEmployee();
                case "2" -> searchEmployee();
                case "3" -> printCompanyData();
                default -> System.err.println("Wpisz cyfrê 0, 1, 2 lub 3.");
            }
        }
    }

    private static void printMenu() {
        System.out.print("""
                Wybierz jedn¹ z opcji:
                   0 - wyjœcie z programu
                   1 - dodaj nowego pracownika
                   2 - wyszukaj pracownika
                   3 - wydrukuj dane o firmie
                """);
    }

    private static void printCompanyData() {
        System.out.println(company);
    }

    private static void searchEmployee() {
        System.out.println("Podaj imiê pracownika:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika:");
        String lastName = scanner.nextLine();

        try {
            Employee em = company.getEmployee(firstName, lastName);
            System.out.println(em);
        } catch (LackOfEmployeeException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addNewEmployee() {
        System.out.println("Podaj imiê pracownika:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika:");
        String lastName = scanner.nextLine();
        System.out.println("Podaj wysokoœæ wyp³aty pracownika:");
        double salary = getSalary();

        company.add(new Employee(firstName, lastName, salary));
    }

    private static double getSalary() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("WprowadŸ poprawn¹ liczbê. Spróbuj jeszcze raz.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private static void exit() {
        System.out.println("Zamykanie programu.");
        System.exit(0);
    }
}
