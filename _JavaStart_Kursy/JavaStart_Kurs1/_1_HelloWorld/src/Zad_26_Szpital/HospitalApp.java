package Zad_26_Szpital;

import java.util.Scanner;

class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        int choice;
        do {
            System.out.println("Wybierz opcjê:");
            System.out.println("0 - wyjœcie");
            System.out.println("1 - dopisz pacjenta");
            System.out.println("2 - wyœwietl listê zapisanych pacjentów");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> hospital.addPatient();
                case 2 -> hospital.displayPatients();
            }

        } while (choice != 0);
    }
}
