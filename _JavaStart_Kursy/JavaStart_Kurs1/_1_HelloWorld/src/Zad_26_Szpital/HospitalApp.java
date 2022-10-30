package Zad_26_Szpital;

import java.util.Scanner;

class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        int choice;
        do {
            System.out.println("Wybierz opcj�:");
            System.out.println("0 - wyj�cie");
            System.out.println("1 - dopisz pacjenta");
            System.out.println("2 - wy�wietl list� zapisanych pacjent�w");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> hospital.addPatient();
                case 2 -> hospital.displayPatients();
            }

        } while (choice != 0);
    }
}
