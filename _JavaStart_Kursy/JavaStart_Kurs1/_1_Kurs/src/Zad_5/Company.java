package Zad_5;

public class Company {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.firstname = "Jan";
        employee1.lastname = "Kowalski";
        employee1.yearOfBirth = 1990;
        employee1.yearsOfExperience = 2;

        Employee employee2 = new Employee();
        employee2.firstname = "Zygmunt";
        employee2.lastname = "Niewiadomski";
        employee2.yearOfBirth = 1978;
        employee2.yearsOfExperience = 1;

        Employee employee3 = new Employee();
        employee3.firstname = "Dawid";
        employee3.lastname = "Poniedzia³ek";
        employee3.yearOfBirth = 1999;
        employee3.yearsOfExperience = 10;

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);

    }
}
