package Zad_26_Szpital;

import java.util.Scanner;

class Hospital {
    private Patient[] patients = new Patient[10];
    private int numOfPatients = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addPatient() {
        if (numOfPatients < patients.length) {
            System.out.print(" - imiê pacjenta: ");
            String firstName = scanner.nextLine();
            System.out.print(" - nazwisko pacjenta: ");
            String lastName = scanner.nextLine();
            System.out.print(" - PESEL pacjenta: ");
            String pesel = scanner.nextLine();

            patients[numOfPatients] = new Patient(firstName, lastName, pesel);
            numOfPatients++;
        } else {
            System.out.println("Limit pacjentów wyczerpany. Zapraszamy za 10 lat!");
        }
    }

    public void displayPatients() {
        System.out.println("Zapisani pacjencji:");
        for (Patient patient : patients) {
            if(patients[0] == null) {
                System.out.println("Brak pacjentów na liœcie.");
                break;
            }
            if (patient == null) continue;
            System.out.printf("%s %s %s\n", patient.getFirstName(), patient.getLastName(), patient.getPesel());
        }
    }
}
