package Zad_5;

public class Employee {
    String firstname;
    String lastname;
    int yearOfBirth;
    int yearsOfExperience;

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
